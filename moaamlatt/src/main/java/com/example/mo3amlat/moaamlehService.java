package com.example.mo3amlat;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.mo3amlat.moaamleh;
@Service
@Transactional
public class moaamlehService {

	@Autowired
	private moaamlehRepository repo;
	
	public List<moaamleh> listAll() {
		return repo.findAll();
	}
	
	public void save(moaamleh product) {
		repo.save(product);
	}
	
	public moaamleh get(long id) {
		return repo.findById((int) id).get();
	}
	
	public void removeMoaamleh(int id )
	{
		repo.deleteById(id);
	}
	public ArrayList<moaamleh> Splace(String place){
		ArrayList<moaamleh> x = new ArrayList<moaamleh>();
		List<moaamleh> y = this.listAll();
		for(int i=0;i<y.size();i++) {
			if(y.get(i).place.contains(place)) {
				x.add(y.get(i));
			}
		}
		return x;
	}
	public ArrayList<moaamleh> Snumber(String number){
		ArrayList<moaamleh> x = new ArrayList<moaamleh>();
		List<moaamleh> y = this.listAll();
		
		for(int i=0;i<y.size();i++) {
			
			if(y.get(i).number.contains(number)) {
				x.add(y.get(i));
			}
		}
		return x;
	}
	
	public ArrayList<moaamleh> Sname(String name ){
		ArrayList<moaamleh> x = new ArrayList<moaamleh>();
		List<moaamleh> y = this.listAll();
		for(int i=0;i<y.size();i++) {
			if(y.get(i).name.contains(name)) {
				x.add(y.get(i));
			}
		}
		return x;
	}
	
	public ArrayList<moaamleh> Sdate(String date ){
		ArrayList<moaamleh> x = new ArrayList<moaamleh>();
		List<moaamleh> y = this.listAll();
		for(int i=0;i<y.size();i++) {
			if(y.get(i).date.contains((date))) {
				x.add(y.get(i));
			}
		}
		return x;
	}
	
	
}

