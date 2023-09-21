import requests
from datetime import datetime, timedelta

import puerta

def get_nbp_data(kraj, dni):
    currency=puerta.country_currency[kraj]
    url = f'http://api.nbp.pl/api/exchangerates/rates/A/{currency}/last/{dni}/?format=json'
    response = requests.get(url)
    return response.json()

def get_weather_data(kraj, dni):
    end_date=datetime.today()- timedelta(days=2)

    print(end_date.strftime("%Y-%m-%d"))
    start_date=end_date - timedelta(days=dni)
    # print(start_date)
    # print(start_date.strftime("%Y-%m-%d"))
    latitude, longitude=puerta.country_wspolrzedne[kraj]
    url=f'https://archive-api.open-meteo.com/v1/archive?latitude={latitude}&longitude={longitude}&start_date={start_date.strftime("%Y-%m-%d")}&end_date={end_date.strftime("%Y-%m-%d")}&daily=temperature_2m_max,temperature_2m_min,temperature_2m_mean,rain_sum,snowfall_sum,windspeed_10m_max&timezone=auto'
    response = requests.get(url)
    return response.json()

if __name__=="__main__":
    print(get_nbp_data("Meksyk", 15))