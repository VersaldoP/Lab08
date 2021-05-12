package it.polito.tdp.extflightdelays.model;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
			
		model.creaGrafo();
		System.out.println(model.getNVertici());
		System.out.println(model.doAnalizzaAeroporti(4000));
		System.out.println(model.getNArchi());
	}

}
