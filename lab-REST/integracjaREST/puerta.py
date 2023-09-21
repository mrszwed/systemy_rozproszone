from fastapi import FastAPI, Depends
from fastapi import Form, Body
from starlette.staticfiles import StaticFiles
from typing_extensions import Annotated

from enum import Enum
from fastapi.responses import HTMLResponse

from fastapi.middleware.cors import CORSMiddleware

from auth.auth_bearer import JWTBearer
from auth.auth_handler import signJWT
import szablon
from schema import UserLoginSchema, UserSchema

origins = [
    "http://localhost:8000",
    "http://localhost:8080",
    "http://localhost:63342",
]
app=FastAPI( )

app.add_middleware(
    CORSMiddleware,
    allow_origins=origins,
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

from pydantic import BaseModel
from typing import List
from typing import Union

weather_features={
    "temperature_2m_max": "maksymalna temperatura",
    "temperature_2m_min": "minimalna temperatura",
    "temperature_2m_mean": "temperatura srednia",
    "rain_sum": "opady deszczu",
    "snowfall_sum": "opady sniegu",
    "windspeed_10m_max": "predkosc wiatru"
}

country_currency={
    "Wielka Brytania": "GBP",
    "Francja": "EUR",
    "Szwajcaria": "CHF",
    "Szwecja": "SEK",
    "Rosja": "RUB",
    "Meksyk": "MXN",
    "USA": "USD"
}

country_wspolrzedne={
    "Wielka Brytania": (54.00, -2.00),
    "Francja": (46.00, 2.00),
    "Szwajcaria": (47.00, 8.01),
    "Szwecja": (62.00, 15.00),
    "Rosja": (60.00, 100.00),
    "Meksyk": (23.00, -102.00),
    "USA": (35.41, -80.58)
}

users = []

def check_user(data: UserLoginSchema):
    for user in users:
        if user.email == data.email and user.password == data.password:
            return True
    return False


@app.get("/countries")
async def get_countries() :
    return {"countries": [c for c in country_currency]}

@app.get("/currencies")
async def get_currencies() :
    return country_currency

@app.get("/weather_features")
async def get_currencies() :
    return weather_features

@app.get("/demo")
async def get_demo() :
    content=szablon.demo_content()
    return HTMLResponse(content=content, status_code=200)

class InputParameters(BaseModel):
    kraj: str
    dni: int
    feature: str


@app.get("/unprotected/dane")
async def get_dane(kraj: Annotated[str, Form()],dni: Annotated[int, Form()],feature: Annotated[str, Form()]) :
    print(kraj,dni,feature)
    content=szablon.build_all(kraj, dni, feature)
    return HTMLResponse(content=content, status_code=200)

@app.post("/dane", dependencies=[Depends(JWTBearer())])
async def get_dane(kraj: Annotated[str, Form()],dni: Annotated[int, Form()],feature: Annotated[str, Form()]) :
    print(kraj,dni,feature)
    content=szablon.build_all(kraj, dni, feature)
    return HTMLResponse(content=content, status_code=200)


@app.get("/")
async def get_main() :
    with open('html/formularz.html', 'r') as file:
        content=file.read()
    return HTMLResponse(content=content, status_code=200)



@app.post("/user/signup",  tags=["user"])
async def create_user(user: UserSchema = Body(...)):
    users.append(user)
    return signJWT(user.email)


@app.post("/user/login", tags=["user"])
async def user_login(user: UserLoginSchema = Body(...)):
    if check_user(user):
        return signJWT(user.email)
    return {
        "error": "Błędne dane logowania!"
    }


app.mount("/", StaticFiles(directory="html"), name="static")


from fastapi import Body, FastAPI, status
from fastapi.responses import JSONResponse

