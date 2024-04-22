package com.visiplus.pret_a_la_consommation.business;

import java.util.Objects;

public class Client {
	private Long id;
	private String nom;
	private String prenom;
	private static Long compteur = 0L;
	
	public Client(String nom, String prenom) {
		super();
		id = ++compteur;
		this.nom = nom;
		this.prenom = prenom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Long getCompteur() {
		return compteur;
	}

	public void setCompteur(Long compteur) {
		Client.compteur = compteur;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nom, prenom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(id, other.id)
				&& Objects.equals(nom, other.nom) && Objects.equals(prenom, other.prenom);
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
}
