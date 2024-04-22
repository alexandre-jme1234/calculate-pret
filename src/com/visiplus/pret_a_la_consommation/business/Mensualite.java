package com.visiplus.pret_a_la_consommation.business;
import java.time.LocalDate;
import java.util.Objects;

public class Mensualite implements Comparable<Mensualite>{
	private Long id;
	private LocalDate datePrelevement;
	private Double partInterestsRembourses;
	private Double partCapitalRembourse;
	private static Long compteur = 0L;
	
	
	// constructor
	public Mensualite(Long id, LocalDate datePrelevement, Double partInterestsRembourses, Double partCapitalRembourse ) {
		super();
		id = ++compteur;
		this.datePrelevement = datePrelevement;
		this.partInterestsRembourses = partInterestsRembourses;
		this.partCapitalRembourse = partCapitalRembourse;
	}
	
	
// getter accès à l'attribut : Accessers
	public Long getId() {
		return id;
	}
	
	
	// modifier attributs : Setters
	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDatePrelevement() {
		return datePrelevement;
	}

	public void setDatePrelevement(LocalDate datePrelevement) {
		this.datePrelevement = datePrelevement;
	}

	public Double getPartInterestsRembourses() {
		return partInterestsRembourses;
	}

	public void setPartInterestsRembourses(Double partInterestsRembourses) {
		this.partInterestsRembourses = partInterestsRembourses;
	}

	public Double getPartCapitalRembourse() {
		return partCapitalRembourse;
	}

	public void setPartCapitalRembourse(Double partCapitalRembourse) {
		this.partCapitalRembourse = partCapitalRembourse;
	}
	
	public static Long getCompteur() {
		return compteur;
	}


	public static void setCompteur(Long compteur) {
		Mensualite.compteur = compteur;
	}


	@Override
	public int hashCode() {
		return Objects.hash(datePrelevement, id, partCapitalRembourse, partInterestsRembourses);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mensualite other = (Mensualite) obj;
		return  Objects.equals(datePrelevement, other.datePrelevement)
				&& Objects.equals(id, other.id) && Objects.equals(partCapitalRembourse, other.partCapitalRembourse)
				&& Objects.equals(partInterestsRembourses, other.partInterestsRembourses);
	}
	
	@Override
	   public int compareTo(Mensualite o) {
	       return Double.compare(o.partInterestsRembourses, this.partInterestsRembourses);
	   }


	@Override
	public String toString() {
		return " " + datePrelevement + " " + partInterestsRembourses;
	}


	
}
