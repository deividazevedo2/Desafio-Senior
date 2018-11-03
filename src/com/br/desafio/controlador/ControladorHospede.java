package com.br.desafio.controlador;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.text.MaskFormatter;

import com.br.desafio.bean.Hospede;

public class ControladorHospede {
	
	private ArrayList<Hospede> checkins;
	private ArrayList<Hospede> checkouts;
	
	private HashMap<String, Double> diarias;
	
	private ArrayList<Hospede> listaDeHospedes = new ArrayList<Hospede>();
	
	public ControladorHospede() {
		checkins = new ArrayList<Hospede>();
		checkouts = new ArrayList<Hospede>();
		
		diarias = new HashMap<String, Double>();
	}
	
	private void alimentandoDiarias() {
		diarias.put("Segunda-Feira", 120.00);
		diarias.put("TerÁa-Feira", 120.00);
		diarias.put("Quarta-Feira", 120.00);
		diarias.put("Quinta-Feira", 120.00);
		diarias.put("Sexta-Feira", 120.00);
		diarias.put("S·bado", 150.00);
		diarias.put("Domingo", 150.00);
	}
	
	public void cadastrarHospede(String nome, String documento, String telefone) {
		Hospede hospede = null;
		if (validarCampo(nome) && validarCampo(documento) && validarCampo(telefone)) {
			hospede = new Hospede(nome, documento, telefone);
			listaDeHospedes.add(hospede);
			
			System.out.println("Cadastro realizado!");
		} else {
			System.out.println("Campos inv·lidos! RefaÁa o cadastro!");
		}
	}
	
	private boolean validarCampo(Object objeto) {
		if (objeto != null) {
			return true;
		}
		return false;
	}
	
	public Hospede buscarHospedePeloNome(String nome) {
		Hospede hospede = null;
		for (Hospede h : listaDeHospedes) {
			if (h.getNome().equals(nome)) {
				hospede = h;
			}
		} 
		return hospede;
	}
	
	private Hospede buscarHospedePeloDocumento(String documento) {
		Hospede hospede = null;
		for (Hospede h : listaDeHospedes) {
			if (h.getDocumento().equals(documento)) {
				hospede = h;
			}
		} 
		return hospede;
	}
	
	private Hospede buscarHospedePeloTelefone(String telefone) {
		Hospede hospede = null;
		for (Hospede h : listaDeHospedes) {
			if (h.getTelefone().equals(telefone)) {
				hospede = h;
			}
		} 
		return hospede;
	}
	
	public Hospede buscar(String hospede) {

		Hospede hosp = null;
		
		if (hospede != null) {
			if (hospede.matches("^[a-zA-Z¡¬√¿«… Õ”‘’⁄‹·‚„‡ÁÈÍÌÛÙı˙¸]*$")) {
				hosp = buscarHospedePeloNome(hospede);
			} else if (hospede.matches("^[0-9]*$")) {
				hosp = buscarHospedePeloDocumento(hospede);
			}
		}
		
		return hosp;
	}
	
	public void fazerCheckin(String hospede, boolean vagaGaragem) {
		Hospede hosp = buscar(hospede);
		Date data = new Date();
		
		if (hosp != null) {
			hosp.setEntrada(data);
			hosp.setVagaGaragem(vagaGaragem);
			
			checkins.add(hosp);
		
			System.out.println("Checkin realizado!");
		} else {
			System.out.println("N„o foi possÌvel realizar o ckeckin!");
		}
		
	}
	
	public void fazerCheckout(String hospede) {

		Hospede hosp = null;
		
		for (Hospede h : checkins) {
			if (h.getNome().equals(hospede) || h.getDocumento().equals(hospede)) {
				hosp = h;
			}
		}

		checkouts.add(hosp);
		
		System.out.println("Checkout realizado!");
	}
	
	private void calculaGastosDoHospede(String nome) {
		Hospede hospede = buscarHospedePeloNome(nome);
		
		if (hospede != null) {
			
		}
	}
	
	private long contaDias(Date checkin, Date checkout) {
		 // Dando um exemplo: quantos dias se passam desde 07/09/1822 atÈ 05/06/2006?
        DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
        df.setLenient(false);
        long diferenca = (checkin.getTime() - checkout.getTime()) + 3600000; // 1 hora para compensar hor·rio de ver„o
        return (diferenca / 86400000L); // passaram-se 67111 dias
	}
	
	public Hospede consultarHospedesCheckin() {
		
		for (Hospede hospede : checkins) {
			return hospede;
		} 
		System.out.println("NinguÈm fez checkin!");
		return null;
		
	}
	
	public Hospede consultarHospedesCheckout() {
		for (Hospede hospede : checkouts) {
			return hospede;
		} 
		System.out.println("NinguÈm fez checkout!");
		return null;
	}
	
	private static String formataTelefone(String telefone) {
		if ( telefone!=null ){
			MaskFormatter formato = null;
			try {
				formato = new MaskFormatter("####-####");
				telefone = formato.getPlaceholder();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return telefone;
		}
		return telefone;
	}
	
	private static String formataData(Date data) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		return dateFormat.format(data);
	}
	
	
	public static void main(String[] args) throws ParseException {
		
		Date d = new Date();
		System.out.println(d.getDay());
    }

}
