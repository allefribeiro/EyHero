package br.com.hero.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Heroi implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String nome;

	private String dataDeCriacao;

	private boolean flgDeleted;

	@OneToOne(fetch = FetchType.LAZY)
	private Universo universo;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Poder> poderes;

	public long getId()
	{
		return id;
	}

	public void setId( long id)
	{
		this.id = id;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome( String nome)
	{
		this.nome = nome;
	}

	public String getDataDeCriacao()
	{
		return dataDeCriacao;
	}

	public void setDataDeCriacao( String dataDeCriacao)
	{
		this.dataDeCriacao = dataDeCriacao;
	}

	public boolean isFlgDeleted()
	{
		return flgDeleted;
	}

	public void setFlgDeleted (boolean flgDeleted)
	{
		this.flgDeleted = flgDeleted;
	}

	public Universo getUniverso()
	{
		return universo;
	}

	public void setUniverso( Universo universo)
	{
		this.universo = universo;
	}

	public List<Poder> getPoderes()
	{
		return poderes;
	}

	public void setPoderes( List<Poder> poderes)
	{
		this.poderes = poderes;
	}
}
