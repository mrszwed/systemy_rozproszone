from pydantic import BaseModel, Field, EmailStr



class UserSchema(BaseModel):
    fullname: str = Field(...)
    email: EmailStr = Field(...)
    password: str = Field(...)

    class Config:
        schema_extra = {
            "example": {
                "fullname": "Antonio Vespucci",
                "email": "hey@mail.com",
                "password": "hello"
            }
        }

class UserLoginSchema(BaseModel):
    email: EmailStr = Field(...)
    password: str = Field(...)

    class Config:
        schema_extra = {
            "example": {
                "email": "hey@mail.com",
                "password": "hello"
            }
        }
