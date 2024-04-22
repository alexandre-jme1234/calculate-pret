package com.visiplus.pret_a_la_consommation.business;
import java.time.*;
import java.util.Objects;

public class Pret {
	private Long id;
	private Double montantdemande;
	private LocalDateTime dateSouscription;
	private LocalDate dateEffect;
	private String observations;
	private static Long compteur = 0L;
	
	public Pret(Double montantdemande, LocalDateTime dateSouscription, LocalDate dateEffect,
			String observations) {
		super();
		id = ++compteur;
		this.montantdemande = montantdemande;
		this.dateSouscription = dateSouscription;
		this.dateEffect = dateEffect;
		this.observations = observations;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getMontantdemande() {
		return montantdemande;
	}

	public void setMontantdemande(Double montantdemande) {
		this.montantdemande = montantdemande;
	}

	public LocalDateTime getDateSouscription() {
		return dateSouscription;
	}

	public void setDateSouscription(LocalDateTime dateSouscription) {
		this.dateSouscription = dateSouscription;
	}

	public LocalDate getDateEffect() {
		return dateEffect;
	}

	public void setDateEffect(LocalDate dateEffect) {
		this.dateEffect = dateEffect;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	// équivalent d'un code barre d'un article : représentation techinque.
	@Override
	public int hashCode() {
		return Objects.hash(compteur, dateEffect, dateSouscription, id, montantdemande, observations);
	}
	
	// représentation fonctionnelle en comparant des obj de type de Pret

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pret other = (Pret) obj;
		return  Objects.equals(dateEffect, other.dateEffect)
				&& Objects.equals(dateSouscription, other.dateSouscription) && Objects.equals(id, other.id)
				&& Objects.equals(montantdemande, other.montantdemande)
				&& Objects.equals(observations, other.observations);
	}

	// méthode affichage de mes obj
	@Override
	public String toString() {
		return "Pret [id=" + id + ", montantdemande=" + montantdemande + ", dateSouscription=" + dateSouscription
				+ ", dateEffect=" + dateEffect + ", observations=" + observations   + "]";
	}
};
