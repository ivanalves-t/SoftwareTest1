package com.exemplo.meu_projeto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

class Calculadora {

    static WebDriver driver;

    @BeforeAll
    static void setup() {
        // Configurando o caminho do WebDriver para Edge
        System.setProperty("webdriver.edge.driver", "C:\\WebDriver\\msedgedriver.exe");
        // Colocar onde o webdriver foi instalado o local

        // Criando a instância do EdgeDriver
        driver = new EdgeDriver();
    }

    @Test
    void test1() {
        driver.get("https://www.calculadoraonline.com.br/basica");
        driver.findElement(By.id("b31")).click();
        driver.findElement(By.id("cx31_0")).sendKeys("3");
        driver.findElement(By.id("cx31_1")).sendKeys("3");
        driver.findElement(By.cssSelector(".uk-button")).click();
        String resultado = driver.findElement(By.id("TIExp")).getAttribute("value");
        assertEquals("27", resultado);
    }
    
    @Test
    void test2() {
        driver.get("https://www.calculadoraonline.com.br/basica");
        driver.findElement(By.id("b31")).click();
        driver.findElement(By.id("cx31_0")).sendKeys("3");
        driver.findElement(By.id("cx31_1")).sendKeys("-1");
        driver.findElement(By.cssSelector(".uk-button")).click();
        String resultado = driver.findElement(By.id("TIExp")).getAttribute("value");
        assertEquals("0,3333333333333333", resultado);
    }
    
    @Test
    void test3() {
        driver.get("https://www.calculadoraonline.com.br/basica");
        driver.findElement(By.id("b31")).click();
        driver.findElement(By.id("cx31_0")).sendKeys("0");
        driver.findElement(By.id("cx31_1")).sendKeys("4");
        driver.findElement(By.cssSelector(".uk-button")).click();
        String resultado = driver.findElement(By.id("TIExp")).getAttribute("value");
        assertEquals("0", resultado);
    }
    
    @Test
    void test4() {
        driver.get("https://www.calculadoraonline.com.br/basica");
        driver.findElement(By.id("b31")).click();
        driver.findElement(By.id("cx31_0")).sendKeys("1024");
        driver.findElement(By.id("cx31_1")).sendKeys("0");
        driver.findElement(By.cssSelector(".uk-button")).click();
        String resultado = driver.findElement(By.id("TIExp")).getAttribute("value");
        assertEquals("1", resultado);
    }
    
    @Test
    void test5() {
        driver.get("https://www.calculadoraonline.com.br/basica");
        driver.findElement(By.id("b31")).click();
        driver.findElement(By.id("cx31_0")).sendKeys("1.3");
        driver.findElement(By.id("cx31_1")).sendKeys("4");
        driver.findElement(By.cssSelector(".uk-button")).click();
        String resultado = driver.findElement(By.id("TIExp")).getAttribute("value");
        assertEquals("2,8561", resultado);
    }
    
    @Test
    void test6() {
        driver.get("https://www.calculadoraonline.com.br/basica");
        driver.findElement(By.id("b31")).click();
        driver.findElement(By.id("cx31_0")).sendKeys("2");
        driver.findElement(By.id("cx31_1")).sendKeys("1.2");
        driver.findElement(By.cssSelector(".uk-button")).click();
        String resultado = driver.findElement(By.id("TIExp")).getAttribute("value");
        assertEquals("2,2973967099940698", resultado);
    }
    
    @Test
    void test7() {
        driver.get("https://www.calculadoraonline.com.br/basica");
        driver.findElement(By.id("b31")).click();
        driver.findElement(By.id("cx31_0")).sendKeys("K");
        driver.findElement(By.id("cx31_1")).sendKeys("4");
        driver.findElement(By.cssSelector(".uk-button")).click();
        String resultado = driver.findElement(By.id("TIExp")).getAttribute("value");
        assertEquals("-", resultado);
    }
    
    @Test
    void test8() {
        driver.get("https://www.calculadoraonline.com.br/basica");
        driver.findElement(By.id("b31")).click();
        driver.findElement(By.id("cx31_0")).sendKeys("2");
        driver.findElement(By.id("cx31_1")).sendKeys("K");
        driver.findElement(By.cssSelector(".uk-button")).click();
        String resultado = driver.findElement(By.id("TIExp")).getAttribute("value");
        assertEquals("-", resultado);
        driver.quit();
    }
    
}
