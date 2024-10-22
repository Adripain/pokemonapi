package fr.efrei.pokemon.dto;

import java.util.List;

public class CreateTrainer {

	private String name;

	private List<String> team;

	public List<String> getInventory() {
		return inventory;
	}

	public void setInventory(List<String> inventory) {
		this.inventory = inventory;
	}

	private List<String> inventory;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getTeam() {
		return team;
	}

	public void setTeam(List<String> team) {
		this.team = team;
	}
}
