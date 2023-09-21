import mpld3
import matplotlib.pyplot as plt
import numpy as np

import fetch
import szablon


def prepare_plot(series1, title, feature, ylabel, label, color="green"):
    fig = plt.figure()
    plt.plot(series1.dates,series1["values"],color=color, lw=2, label=label)
    x = np.linspace(0,10)
    plt.xlabel('data')
    plt.ylabel(ylabel)
    plt.title(title)
    plt.legend()
    plt.grid(True)
    html_plot = mpld3.fig_to_html(fig)
    return html_plot

if __name__=="__main__":
    nbp_data = fetch.get_nbp_data("Francja", 15)
    weather_data = fetch.get_weather_data("Francja", 15)
    nbp_df = szablon.build_nbp_df(nbp_data)
    weather_df = szablon.build_weather_df(weather_data, "temperature_2m_mean")
    p=prepare_plot(nbp_df, weather_df, "wykres", feature="temperature_2m_mean")
    print(p)