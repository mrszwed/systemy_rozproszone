from datetime import datetime
import json
import pandas as pd
from scipy.stats import pearsonr

import fetch
import puerta
import wykres


szablon="""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Odpowiedz</title>
</head>
<body>

<h1>Wybrany kraj: {kraj}</h1>
<h2>kurs waluty {currency} i pogoda przez ostatnie {dni} dni</h2>
<ul>

</ul>

<p>w ciągu ostatnich {dni} dni średnia {feature} wynosiła: {f_avg:.2f}, max {feature}: {f_max:.2f}, min {feature}: {f_min:.2f}</p>
<p> waluta {currency} najwięcej była warta: {c_max:.2f} PLN, najmniej {c_min:.2f} PLN, a średnia wynosiła {c_avg:.2f} PLN</p>

<h2>Współczynnik korelacji Pearsona: {pearsonr} między kursem {currency} i wartością {feature}</h2>

<div>
{html_plot_nbp}
</div>

<div>
{html_plot_weather}
</div>

</body>
</html>
"""




def build_nbp_df(nbp_json):
    nbp_dates = []
    nbp_rates = []
    for r in nbp_json["rates"]:
        strdate=r["effectiveDate"]
        date_time=datetime.strptime(strdate, '%Y-%m-%d')
        nbp_dates.append(date_time)
        nbp_rates.append(r["mid"])
    nbp_dict = {"dates": nbp_dates, "values": nbp_rates}
    nbp_df = pd.DataFrame(nbp_dict)
    return nbp_df

def build_weather_df(dict_json, feature):
    dates=[datetime.strptime(strdate, '%Y-%m-%d') for strdate in dict_json["daily"]["time"]]
    dict = {"dates": dates, "values": dict_json["daily"][feature]}
    df = pd.DataFrame(dict)
    return df

def formatHTML(weather_df, nbp_df, kraj, currency, feature):
    dni=len(weather_df)
    c_max = nbp_df["values"].max()
    c_min = nbp_df["values"].min()
    c_avg = nbp_df["values"].mean()

    f_max = weather_df["values"].max()
    f_min = weather_df["values"].min()
    f_avg = weather_df["values"].mean()

    df_w=weather_df["values"].dropna()
    df_w_len=len(df_w)
    nbp_df_skr=nbp_df["values"][:df_w_len]

    corr, _ = pearsonr(nbp_df_skr, df_w)

    plot_nbp=wykres.prepare_plot(nbp_df, "Wykres kursu waluty", puerta.weather_features[feature], ylabel="cena PLN", label=currency, color="blue")
    plot_weather = wykres.prepare_plot(weather_df, "Wykres cechy pogody", puerta.weather_features[feature], ylabel=puerta.weather_features[feature], label=puerta.weather_features[feature], color="red")

    template_params={"c_max": c_max, "c_min": c_min, "c_avg":c_avg, "f_max":f_max, "f_min":f_min, "f_avg":f_avg, "dni":dni, "kraj":kraj, "currency":currency, "feature":puerta.weather_features[feature], "html_plot_nbp":plot_nbp, "html_plot_weather": plot_weather, "pearsonr": corr}
    return szablon.format(**template_params)


def build_all(kraj, dni, feature):
    nbp_data=fetch.get_nbp_data(kraj, dni)
    weather_data = fetch.get_weather_data(kraj, dni)
    nbp_df=build_nbp_df(nbp_data)
    weather_df = build_weather_df(weather_data, feature)
    return formatHTML(weather_df, nbp_df, kraj, puerta.country_currency[kraj], feature)



#########################DEMO

def demo_content():
    json_response1 = """
        {"latitude":52.0,"longitude":20.0,"generationtime_ms":1.092076301574707,"utc_offset_seconds":3600,"timezone":"Europe/Warsaw","timezone_abbreviation":"CET","elevation":113.0,"daily_units":{"time":"iso8601","temperature_2m_max":"°C","temperature_2m_min":"°C","temperature_2m_mean":"°C","rain_sum":"mm","snowfall_sum":"cm","windspeed_10m_max":"km/h"},"daily":{"time":["2023-02-13","2023-02-14","2023-02-15","2023-02-16","2023-02-17","2023-02-18","2023-02-19","2023-02-20","2023-02-21","2023-02-22","2023-02-23","2023-02-24","2023-02-25","2023-02-26","2023-02-27","2023-02-28","2023-03-01","2023-03-02","2023-03-03","2023-03-04","2023-03-05","2023-03-06","2023-03-07","2023-03-08","2023-03-09","2023-03-10","2023-03-11","2023-03-12","2023-03-13","2023-03-14"],"temperature_2m_max":[6.5,7.0,6.2,7.3,9.6,8.2,5.1,7.8,8.2,4.5,6.3,7.4,4.4,2.0,0.8,2.1,5.8,3.8,2.5,4.0,2.0,3.1,5.5,4.8,0.6,10.4,6.4,5.2,1.2,null],"temperature_2m_min":[3.7,0.9,-0.5,-0.9,2.4,2.3,0.2,0.1,4.9,-1.6,-2.3,3.2,0.3,-1.8,-3.2,-4.3,-4.9,-2.5,-2.8,-3.8,-4.3,-4.5,-4.1,-0.4,-0.8,-0.8,-1.6,-2.0,1.2,null],"temperature_2m_mean":[4.7,3.0,2.2,2.5,5.5,5.3,2.6,3.9,6.8,1.8,1.8,5.6,2.5,-0.1,-1.1,-1.5,-0.3,0.6,-0.3,0.6,-1.6,-1.1,1.0,1.7,-0.1,5.0,2.4,1.4,null,null],"rain_sum":[0.20,0.00,0.00,0.00,9.70,2.50,0.20,3.30,2.80,0.00,0.10,2.70,4.20,0.00,0.00,0.00,0.00,0.00,0.00,1.50,0.20,1.30,0.90,1.20,0.00,5.40,1.70,0.00,null,null],"snowfall_sum":[0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.21,0.70,0.00,0.00,0.00,0.00,0.00,0.00,0.98,1.61,0.00,3.71,3.92,0.84,1.68,0.07,null,null],"windspeed_10m_max":[26.3,18.5,10.4,17.0,34.2,37.2,24.1,37.4,37.2,14.3,17.9,18.5,21.9,20.2,14.7,8.0,11.4,7.9,18.6,27.8,16.3,17.2,25.7,21.7,22.4,21.1,30.3,33.1,12.2,null]}}
        """
    nbp_response = """
        {"table":"A","currency":"peso meksykańskie","code":"MXN","rates":[{"no":"025/A/NBP/2023","effectiveDate":"2023-02-06","mid":0.2300},{"no":"026/A/NBP/2023","effectiveDate":"2023-02-07","mid":0.2320},{"no":"027/A/NBP/2023","effectiveDate":"2023-02-08","mid":0.2337},{"no":"028/A/NBP/2023","effectiveDate":"2023-02-09","mid":0.2331},{"no":"029/A/NBP/2023","effectiveDate":"2023-02-10","mid":0.2374},{"no":"030/A/NBP/2023","effectiveDate":"2023-02-13","mid":0.2400},{"no":"031/A/NBP/2023","effectiveDate":"2023-02-14","mid":0.2396},{"no":"032/A/NBP/2023","effectiveDate":"2023-02-15","mid":0.2382},{"no":"033/A/NBP/2023","effectiveDate":"2023-02-16","mid":0.2403},{"no":"034/A/NBP/2023","effectiveDate":"2023-02-17","mid":0.2412},{"no":"035/A/NBP/2023","effectiveDate":"2023-02-20","mid":0.2416},{"no":"036/A/NBP/2023","effectiveDate":"2023-02-21","mid":0.2417},{"no":"037/A/NBP/2023","effectiveDate":"2023-02-22","mid":0.2420},{"no":"038/A/NBP/2023","effectiveDate":"2023-02-23","mid":0.2453},{"no":"039/A/NBP/2023","effectiveDate":"2023-02-24","mid":0.2426},{"no":"040/A/NBP/2023","effectiveDate":"2023-02-27","mid":0.2431},{"no":"041/A/NBP/2023","effectiveDate":"2023-02-28","mid":0.2424},{"no":"042/A/NBP/2023","effectiveDate":"2023-03-01","mid":0.2413},{"no":"043/A/NBP/2023","effectiveDate":"2023-03-02","mid":0.2430},{"no":"044/A/NBP/2023","effectiveDate":"2023-03-03","mid":0.2454},{"no":"045/A/NBP/2023","effectiveDate":"2023-03-06","mid":0.2466},{"no":"046/A/NBP/2023","effectiveDate":"2023-03-07","mid":0.2446},{"no":"047/A/NBP/2023","effectiveDate":"2023-03-08","mid":0.2471},{"no":"048/A/NBP/2023","effectiveDate":"2023-03-09","mid":0.2477},{"no":"049/A/NBP/2023","effectiveDate":"2023-03-10","mid":0.2413},{"no":"050/A/NBP/2023","effectiveDate":"2023-03-13","mid":0.2381},{"no":"051/A/NBP/2023","effectiveDate":"2023-03-14","mid":0.2304},{"no":"052/A/NBP/2023","effectiveDate":"2023-03-15","mid":0.2347},{"no":"053/A/NBP/2023","effectiveDate":"2023-03-16","mid":0.2327},{"no":"054/A/NBP/2023","effectiveDate":"2023-03-17","mid":0.2370}]}
        """
    dict_json = json.loads(json_response1)
    feature = "temperature_2m_mean"
    dict = {"dates": dict_json["daily"]["time"], "values": dict_json["daily"][feature]}
    df = pd.DataFrame(dict)

    nbp_json = json.loads(nbp_response)
    nbp_dates = []
    nbp_rates = []
    for r in nbp_json["values"]:
        nbp_dates.append(r["effectiveDate"])
        nbp_rates.append(r["mid"])
    nbp_dict = {"dates": nbp_dates, "values": nbp_rates}
    nbp_df = pd.DataFrame(nbp_dict)
    return formatHTML(df, nbp_df, "Polska", "MXN", "temperature_2m_mean")

if __name__=='__main__':
    json_response1 = """
    {"latitude":52.0,"longitude":20.0,"generationtime_ms":1.092076301574707,"utc_offset_seconds":3600,"timezone":"Europe/Warsaw","timezone_abbreviation":"CET","elevation":113.0,"daily_units":{"time":"iso8601","temperature_2m_max":"°C","temperature_2m_min":"°C","temperature_2m_mean":"°C","rain_sum":"mm","snowfall_sum":"cm","windspeed_10m_max":"km/h"},"daily":{"time":["2023-02-13","2023-02-14","2023-02-15","2023-02-16","2023-02-17","2023-02-18","2023-02-19","2023-02-20","2023-02-21","2023-02-22","2023-02-23","2023-02-24","2023-02-25","2023-02-26","2023-02-27","2023-02-28","2023-03-01","2023-03-02","2023-03-03","2023-03-04","2023-03-05","2023-03-06","2023-03-07","2023-03-08","2023-03-09","2023-03-10","2023-03-11","2023-03-12","2023-03-13","2023-03-14"],"temperature_2m_max":[6.5,7.0,6.2,7.3,9.6,8.2,5.1,7.8,8.2,4.5,6.3,7.4,4.4,2.0,0.8,2.1,5.8,3.8,2.5,4.0,2.0,3.1,5.5,4.8,0.6,10.4,6.4,5.2,1.2,null],"temperature_2m_min":[3.7,0.9,-0.5,-0.9,2.4,2.3,0.2,0.1,4.9,-1.6,-2.3,3.2,0.3,-1.8,-3.2,-4.3,-4.9,-2.5,-2.8,-3.8,-4.3,-4.5,-4.1,-0.4,-0.8,-0.8,-1.6,-2.0,1.2,null],"temperature_2m_mean":[4.7,3.0,2.2,2.5,5.5,5.3,2.6,3.9,6.8,1.8,1.8,5.6,2.5,-0.1,-1.1,-1.5,-0.3,0.6,-0.3,0.6,-1.6,-1.1,1.0,1.7,-0.1,5.0,2.4,1.4,null,null],"rain_sum":[0.20,0.00,0.00,0.00,9.70,2.50,0.20,3.30,2.80,0.00,0.10,2.70,4.20,0.00,0.00,0.00,0.00,0.00,0.00,1.50,0.20,1.30,0.90,1.20,0.00,5.40,1.70,0.00,null,null],"snowfall_sum":[0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.21,0.70,0.00,0.00,0.00,0.00,0.00,0.00,0.98,1.61,0.00,3.71,3.92,0.84,1.68,0.07,null,null],"windspeed_10m_max":[26.3,18.5,10.4,17.0,34.2,37.2,24.1,37.4,37.2,14.3,17.9,18.5,21.9,20.2,14.7,8.0,11.4,7.9,18.6,27.8,16.3,17.2,25.7,21.7,22.4,21.1,30.3,33.1,12.2,null]}}
    """
    nbp_response="""
    {"table":"A","currency":"peso meksykańskie","code":"MXN","rates":[{"no":"025/A/NBP/2023","effectiveDate":"2023-02-06","mid":0.2300},{"no":"026/A/NBP/2023","effectiveDate":"2023-02-07","mid":0.2320},{"no":"027/A/NBP/2023","effectiveDate":"2023-02-08","mid":0.2337},{"no":"028/A/NBP/2023","effectiveDate":"2023-02-09","mid":0.2331},{"no":"029/A/NBP/2023","effectiveDate":"2023-02-10","mid":0.2374},{"no":"030/A/NBP/2023","effectiveDate":"2023-02-13","mid":0.2400},{"no":"031/A/NBP/2023","effectiveDate":"2023-02-14","mid":0.2396},{"no":"032/A/NBP/2023","effectiveDate":"2023-02-15","mid":0.2382},{"no":"033/A/NBP/2023","effectiveDate":"2023-02-16","mid":0.2403},{"no":"034/A/NBP/2023","effectiveDate":"2023-02-17","mid":0.2412},{"no":"035/A/NBP/2023","effectiveDate":"2023-02-20","mid":0.2416},{"no":"036/A/NBP/2023","effectiveDate":"2023-02-21","mid":0.2417},{"no":"037/A/NBP/2023","effectiveDate":"2023-02-22","mid":0.2420},{"no":"038/A/NBP/2023","effectiveDate":"2023-02-23","mid":0.2453},{"no":"039/A/NBP/2023","effectiveDate":"2023-02-24","mid":0.2426},{"no":"040/A/NBP/2023","effectiveDate":"2023-02-27","mid":0.2431},{"no":"041/A/NBP/2023","effectiveDate":"2023-02-28","mid":0.2424},{"no":"042/A/NBP/2023","effectiveDate":"2023-03-01","mid":0.2413},{"no":"043/A/NBP/2023","effectiveDate":"2023-03-02","mid":0.2430},{"no":"044/A/NBP/2023","effectiveDate":"2023-03-03","mid":0.2454},{"no":"045/A/NBP/2023","effectiveDate":"2023-03-06","mid":0.2466},{"no":"046/A/NBP/2023","effectiveDate":"2023-03-07","mid":0.2446},{"no":"047/A/NBP/2023","effectiveDate":"2023-03-08","mid":0.2471},{"no":"048/A/NBP/2023","effectiveDate":"2023-03-09","mid":0.2477},{"no":"049/A/NBP/2023","effectiveDate":"2023-03-10","mid":0.2413},{"no":"050/A/NBP/2023","effectiveDate":"2023-03-13","mid":0.2381},{"no":"051/A/NBP/2023","effectiveDate":"2023-03-14","mid":0.2304},{"no":"052/A/NBP/2023","effectiveDate":"2023-03-15","mid":0.2347},{"no":"053/A/NBP/2023","effectiveDate":"2023-03-16","mid":0.2327},{"no":"054/A/NBP/2023","effectiveDate":"2023-03-17","mid":0.2370}]}
    """
    dict_json=json.loads(json_response1)
    feature="temperature_2m_mean"
    dict={"dates": dict_json["daily"]["time"], "values": dict_json["daily"][feature]}
    df=pd.DataFrame(dict)
    print(df.head())

    nbp_json = json.loads(nbp_response)
    nbp_dates=[]
    nbp_rates=[]
    for r in nbp_json["rates"]:
        nbp_dates.append(r["effectiveDate"])
        nbp_rates.append(r["mid"])
    nbp_dict={"dates": nbp_dates, "values": nbp_rates}
    nbp_df=pd.DataFrame(nbp_dict)
    print(nbp_df.head())
    print()
    print("------------")
    print()
    print(formatHTML(df, nbp_df, "Polska", "MXN", "temperature_2m_mean"))




