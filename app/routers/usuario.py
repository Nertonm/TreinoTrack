from fastapi import APIRouter, Depends, HTTPException
from sqlalchemy.orm import Session
from database import SessionLocal
from models.usuario import Usuario
from schemas.usuario import UsuarioCreate, UsuarioRead, UsuarioUpdate
from typing import List

router = APIRouter(prefix="/usuarios", tags=["Usuários"])

def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()

# CREATE
@router.post("/", response_model=UsuarioRead)
def criar_usuario(usuario: UsuarioCreate, db: Session = Depends(get_db)):
    # Verificar se o CPF já existe
    db_usuario_existente = db.query(Usuario).filter(Usuario.cpf == usuario.cpf).first()
    if db_usuario_existente:
        raise HTTPException(status_code=400, detail="CPF já cadastrado")
    # Verificar se o e-mail já existe
    db_email_existente = db.query(Usuario).filter(Usuario.email == usuario.email).first()
    if db_email_existente:
        raise HTTPException(status_code=400, detail="E-mail já cadastrado")
    # Criar o novo usuário
    db_usuario = Usuario(
        nome=usuario.nome,
        email=usuario.email,
        cpf=usuario.cpf,
        data_nascimento=usuario.data_nascimento,
        tipo=usuario.tipo
    )
    db.add(db_usuario)
    db.commit()
    db.refresh(db_usuario)
    return db_usuario



# READ ALL
@router.get("/", response_model=List[UsuarioRead])  # A rota GET para listar usuários
def listar_usuarios(db: Session = Depends(get_db)):
    usuarios = db.query(Usuario).all()
    if not usuarios:
        raise HTTPException(status_code=404, detail="Nenhum usuário encontrado")
    return usuarios

# READ ONE
@router.get("/{usuario_id}", response_model=UsuarioRead)
def obter_usuario(usuario_id: int, db: Session = Depends(get_db)):
    usuario = db.query(Usuario).get(usuario_id)
    if not usuario:
        raise HTTPException(status_code=404, detail="Usuário não encontrado")
    return usuario

# UPDATE
@router.put("/{usuario_id}", response_model=UsuarioRead)
def atualizar_usuario(usuario_id: int, dados: UsuarioUpdate, db: Session = Depends(get_db)):
    usuario = db.query(Usuario).get(usuario_id)
    if not usuario:
        raise HTTPException(status_code=404, detail="Usuário não encontrado")
    
    for campo, valor in dados.dict(exclude_unset=True).items():
        setattr(usuario, campo, valor)

    db.commit()
    db.refresh(usuario)
    return usuario

# DELETE
@router.delete("/{usuario_id}")
def deletar_usuario(usuario_id: int, db: Session = Depends(get_db)):
    usuario = db.query(Usuario).get(usuario_id)
    if not usuario:
        raise HTTPException(status_code=404, detail="Usuário não encontrado")
    db.delete(usuario)
    db.commit()
    return {"detail": "Usuário deletado com sucesso"}
