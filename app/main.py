from fastapi import FastAPI
from database import Base, engine
from routers import usuario, meta, avaliacaofisica, equipamento, exercicio, musculo
from routers import registrotreino, treino, treinoexercicio, usuariotreino, frontend
from fastapi.responses import HTMLResponse

app = FastAPI(title="FitLife API")

Base.metadata.create_all(bind=engine)

app.include_router(usuario.router)
app.include_router(meta.router)
app.include_router(avaliacaofisica.router)
app.include_router(equipamento.router)
app.include_router(exercicio.router)
app.include_router(musculo.router)
app.include_router(registrotreino.router)
app.include_router(treino.router)
app.include_router(treinoexercicio.router)
app.include_router(usuariotreino.router)
app.include_router(frontend.router)

