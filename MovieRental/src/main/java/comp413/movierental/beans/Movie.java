/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp413.movierental.beans;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author Waley
 */
@Entity
@Table(name = "MOVIE")
@NamedQueries({
    @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m"),
    @NamedQuery(name = "Movie.findById", query = "SELECT m FROM Movie m WHERE m.id = :id"),
    @NamedQuery(name = "Movie.findByTitle", query = "SELECT m FROM Movie m WHERE m.title = :title"),
    @NamedQuery(name = "Movie.findByMovieyear", query = "SELECT m FROM Movie m WHERE m.movieyear = :movieyear"),
    @NamedQuery(name = "Movie.findByGenre", query = "SELECT m FROM Movie m WHERE m.genre = :genre"),
    @NamedQuery(name = "Movie.findByLeadingactor", query = "SELECT m FROM Movie m WHERE m.leadingactor = :leadingactor"),
    @NamedQuery(name = "Movie.findByStudio", query = "SELECT m FROM Movie m WHERE m.studio = :studio"),
    @NamedQuery(name = "Movie.findByDirector", query = "SELECT m FROM Movie m WHERE m.director = :director"),
    @NamedQuery(name = "Movie.findByLength", query = "SELECT m FROM Movie m WHERE m.length = :length"),
    @NamedQuery(name = "Movie.findByRentalprice", query = "SELECT m FROM Movie m WHERE m.rentalprice = :rentalprice"),
    @NamedQuery(name = "Movie.findByCostproduction", query = "SELECT m FROM Movie m WHERE m.costproduction = :costproduction"),
    @NamedQuery(name = "Movie.findByEstimatedboxofficerevenue", query = "SELECT m FROM Movie m WHERE m.estimatedboxofficerevenue = :estimatedboxofficerevenue")})
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "TITLE")
    private String title;
    @Column(name = "MOVIEYEAR")
    private Integer movieyear;
    @Column(name = "GENRE")
    private String genre;
    @Column(name = "LEADINGACTOR")
    private String leadingactor;
    @Column(name = "STUDIO")
    private String studio;
    @Column(name = "DIRECTOR")
    private String director;
    @Column(name = "LENGTH")
    private Double length;
    @Basic(optional = false)
    @Column(name = "RENTALPRICE")
    private double rentalprice;
    @Column(name = "COSTPRODUCTION")
    private Double costproduction;
    @Column(name = "ESTIMATEDBOXOFFICEREVENUE")
    private Double estimatedboxofficerevenue;

    public Movie() {
    }

    public Movie(Integer id) {
        this.id = id;
    }

    public Movie(Integer id, String title, Double rentalprice) {
        this.id = id;
        this.title = title;
        this.rentalprice = rentalprice;
    }
    
    public Movie(Integer id, String title, Integer movieyear, String genre, String leadingactor, String studio, 
                 String director, Double length, Double rentalprice, Double costproduction, 
                 Double estimatedboxofficerevenue) {
        this.id = id;
        this.title = title;
        this.movieyear = movieyear;
        this.genre = genre;
        this.leadingactor = leadingactor;
        this.studio = studio;
        this.director = director;
        this.length = length;
        this.rentalprice = rentalprice;
        this.costproduction = costproduction;
        this.estimatedboxofficerevenue = estimatedboxofficerevenue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getMovieyear() {
        return movieyear;
    }

    public void setMovieyear(Integer movieyear) {
        this.movieyear = movieyear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLeadingactor() {
        return leadingactor;
    }

    public void setLeadingactor(String leadingactor) {
        this.leadingactor = leadingactor;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getRentalprice() {
        return rentalprice;
    }

    public void setRentalprice(Double rentalprice) {
        this.rentalprice = rentalprice;
    }

    public Double getCostproduction() {
        return costproduction;
    }

    public void setCostproduction(Double costproduction) {
        this.costproduction = costproduction;
    }

    public Double getEstimatedboxofficerevenue() {
        return estimatedboxofficerevenue;
    }

    public void setEstimatedboxofficerevenue(Double estimatedboxofficerevenue) {
        this.estimatedboxofficerevenue = estimatedboxofficerevenue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "comp413.movierental.beans.Movie[ id=" + id + " ]";
    }
    
}
