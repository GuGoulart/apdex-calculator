// [Gustavo Goulart Bretas] - RM[555708]
package com.gustavogoulart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ApdexTest {

    private Apdex apdex;
    private int totalAmostras;

    @BeforeEach
    public void setUp() {
        totalAmostras = 555708;
        apdex = new Apdex();
    }

    @Test
    public void testCalcularApdexExcelente() {
        int satisfatorias = (int)(totalAmostras * 0.95); // 95% satisfatórias
        int toleraveis = (int)(totalAmostras * 0.03);    // 3% toleráveis
        int frustrantes = totalAmostras - satisfatorias - toleraveis; // restoo

        double resultado = apdex.calcularApdex(satisfatorias, toleraveis, frustrantes);

        assertTrue(resultado >= 0.94 && resultado <= 1.0,
                "APDEX deveria ser Excelente (0.94-1.0), mas foi: " + resultado);
    }

    @Test
    public void testCalcularApdexBom() {
        int satisfatorias = (int)(totalAmostras * 0.85); // 85% satisfatórias
        int toleraveis = (int)(totalAmostras * 0.08);    // 8% toleráveis
        int frustrantes = totalAmostras - satisfatorias - toleraveis;

        double resultado = apdex.calcularApdex(satisfatorias, toleraveis, frustrantes);

        assertTrue(resultado >= 0.85 && resultado <= 0.93,
                "APDEX deveria ser Bom (0.85-0.93), mas foi: " + resultado);
    }

    @Test
    public void testCalcularApdexRazoavel() {
        int satisfatorias = (int)(totalAmostras * 0.75); // 75% satisfatórias
        int toleraveis = (int)(totalAmostras * 0.05);    // 5% toleráveis
        int frustrantes = totalAmostras - satisfatorias - toleraveis;

        double resultado = apdex.calcularApdex(satisfatorias, toleraveis, frustrantes);

        assertTrue(resultado >= 0.70 && resultado <= 0.84,
                "APDEX deveria ser Razoável (0.70-0.84), mas foi: " + resultado);
    }

    @Test
    public void testCalcularApdexRuim() {
        int satisfatorias = (int)(totalAmostras * 0.55); // 55% satisfatórias
        int toleraveis = (int)(totalAmostras * 0.05);    // 5% toleráveis
        int frustrantes = totalAmostras - satisfatorias - toleraveis;

        double resultado = apdex.calcularApdex(satisfatorias, toleraveis, frustrantes);

        assertTrue(resultado >= 0.50 && resultado <= 0.69,
                "APDEX deveria ser Ruim (0.50-0.69), mas foi: " + resultado);
    }

    @Test
    public void testCalcularApdexInaceitavel() {
        int satisfatorias = (int)(totalAmostras * 0.30); // 30% satisfatórias
        int toleraveis = (int)(totalAmostras * 0.05);    // 5% toleráveis
        int frustrantes = totalAmostras - satisfatorias - toleraveis;

        double resultado = apdex.calcularApdex(satisfatorias, toleraveis, frustrantes);

        assertTrue(resultado >= 0.0 && resultado <= 0.49,
                "APDEX deveria ser Inaceitável (0.0-0.49), mas foi: " + resultado);
    }

    @Test
    public void testClassificarApdexExcelente() {
        String classificacao = apdex.classificarApdex(0.97);

        assertEquals("Excelente", classificacao);
    }

    @Test
    public void testClassificarApdexBom() {
        String classificacao = apdex.classificarApdex(0.88);

        assertEquals("Bom", classificacao);
    }

    @Test
    public void testClassificarApdexRazoavel() {
        String classificacao = apdex.classificarApdex(0.76);

        assertEquals("Razoável", classificacao);
    }

    @Test
    public void testClassificarApdexRuim() {
        String classificacao = apdex.classificarApdex(0.58);

        assertEquals("Ruim", classificacao);
    }

    @Test
    public void testClassificarApdexInaceitavel() {
        String classificacao = apdex.classificarApdex(0.35);

        assertEquals("Inaceitável", classificacao);
    }

    @Test
    public void testCalcularApdexComValoresZero() {
        double resultado = apdex.calcularApdex(0, 0, totalAmostras);

        assertEquals(0.0, resultado);
    }

    @Test
    public void testCalcularApdexComTotalZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            apdex.calcularApdex(0, 0, 0);
        });
    }
}