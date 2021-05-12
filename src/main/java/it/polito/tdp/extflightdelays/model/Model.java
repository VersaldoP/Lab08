package it.polito.tdp.extflightdelays.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {
	
	private ExtFlightDelaysDAO dao;
	private Map<Integer,Airport> airports;
	private Graph<Airport,DefaultWeightedEdge> grafo;
	
	public Model() {
		dao = new ExtFlightDelaysDAO();
		airports = new HashMap<>();
	}
	public void creaGrafo() {
		grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		dao.loadAllAirports(airports);
		Graphs.addAllVertices(grafo,airports.values());
	}
	
	
	public String doAnalizzaAeroporti(int distance ) {
		List<Volo> voli = dao.loadVoli(distance);
		StringBuilder vv = new StringBuilder();
		for(Volo v:voli) {
			DefaultWeightedEdge e = this.grafo.getEdge(airports.get(v.getPartenza()),airports.get(v.getArrivo()));
			if (e==null) {
			Graphs.addEdge(this.grafo,airports.get(v.getPartenza()),airports.get(v.getArrivo()),v.getDistance());
			vv.append(airports.get(v.getPartenza()).getAirportName()+" , "+airports.get(v.getArrivo()).getAirportName()+" : "+v.getDistance()+"\n ");
			}
			else {
				double pesoVecchio= this.grafo.getEdgeWeight(e);
				double pesoNuovo = (pesoVecchio + v.getDistance())/2;
				this.grafo.setEdgeWeight(e,pesoNuovo);
			}
		}
		return vv.toString();
	}
	public String getNVertici() {
		// TODO Auto-generated method stub
		return ""+grafo.vertexSet().size();
	}
	public String getNArchi() {
		// TODO Auto-generated method stub
		return ""+grafo.edgeSet().size();
	}
	

}
