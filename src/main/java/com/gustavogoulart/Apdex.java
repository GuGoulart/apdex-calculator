// [Gustavo Goulart Bretas] - RM[555708]
package com.gustavogoulart;

public class Apdex {

    public double calcularApdex(int satisfatorias, int toleraveis, int frustrantes) {
        int totalAmostras = satisfatorias + toleraveis + frustrantes;

        if (totalAmostras == 0) {
            throw new IllegalArgumentException("Total de amostras não pode ser zero");
        }

        // Fórmula APDEX
        double apdex = (satisfatorias + (toleraveis / 2.0)) / totalAmostras;

        if (apdex > 1.0) {
            apdex = 1.0;
        } else if (apdex < 0.0) {
            apdex = 0.0;
        }

        return apdex;
    }

    public String classificarApdex(double valorApdex) {
        if (valorApdex >= 0.94 && valorApdex <= 1.0) {
            return "Excelente";
        } else if (valorApdex >= 0.85 && valorApdex <= 0.93) {
            return "Bom";
        } else if (valorApdex >= 0.70 && valorApdex <= 0.84) {
            return "Razoável";
        } else if (valorApdex >= 0.50 && valorApdex <= 0.69) {
            return "Ruim";
        } else if (valorApdex >= 0.0 && valorApdex <= 0.49) {
            return "Inaceitável";
        } else {
            throw new IllegalArgumentException("Valor APDEX deve estar entre 0.0 e 1.0");
        }
    }
}