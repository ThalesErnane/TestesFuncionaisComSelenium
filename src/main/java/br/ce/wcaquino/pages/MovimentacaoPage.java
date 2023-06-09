package br.ce.wcaquino.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.wcaquino.core.BasePage;
import br.ce.wcaquino.core.DriverFactory;

public class MovimentacaoPage extends BasePage {

	public void setDataMovimentacao(String data) {
		escrever("data_transacao", data);
	}
	
	public void setDataPagamento(String data) {
		escrever("data_pagamento", data);
	}
	
	public void setDescricao(String descricao) {
		escrever("descricao", descricao);
	}
	
	public void setInteressado(String interessado) {
		escrever("interessado", interessado);
	}
	
	public void setValor(String valor) {
		escrever("valor", valor);
	}
	
	public void setConta(String conta) {
		selecionarCombo("conta", conta);
	}
	
	public void setStatusPago() {
		clicarRadioButton("status_pago");
	}
	
	public void salvar() {
		clicarBotaoPorTexto("Salvar");
	}
	
	public String obterMensagemSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public String obterMensagemErro() {
		return obterTexto(By.xpath("//div[@class='alert alert-danger']"));
	}
	
	public List<String> obterErros(){
		List<WebElement> erros = DriverFactory.getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
		List<String> retorno = new ArrayList();
		for (WebElement erro: erros) {
			retorno.add(erro.getText()); // pega o texto de cada li
		}
		return retorno;
	}
}
