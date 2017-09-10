package br.pro.ramon.modelos;

public class Aluno {

    private String nome;
    private double p1, p2;

    public Aluno(String nome, double p1, double p2) throws NotaInvalidaException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException();
        } else if (p1 < 0 || p1 > 10 || p2 < 0 || p2 > 10) {
            throw new NotaInvalidaException();
        }

        this.nome = nome;
        this.p1 = p1;
        this.p2 = p2;
    }

    public double getMedia() {
        return (p1 + p2) / 2;
    }

    public boolean getAprovado() {
        return getMedia() >= 6;
    }

}
