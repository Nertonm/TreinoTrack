from fastapi import FastAPI
from database import Base, engine
from routers import usuario

app = FastAPI(title="FitLife API")

Base.metadata.create_all(bind=engine)

app.include_router(usuario.router)
