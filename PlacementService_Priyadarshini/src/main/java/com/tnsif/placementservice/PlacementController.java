package com.tnsif.placementservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.NoResultException;

@RestController
public class PlacementController {
	@Autowired
	private PlacementService pla;
	@GetMapping("/placementservice")
	public List<Placement> list()
	{
		return pla.listAll();
	}
	@PostMapping("/placementservice")
	public void add (@RequestBody Placement pla1)
	{
		pla.save(pla1);
	}
	@GetMapping("/placementservice/{id}")
	public ResponseEntity<Placement> get(@PathVariable Integer id)
	{
		try
		{
			Placement p=pla.get(id);
			return new ResponseEntity<Placement>(p,HttpStatus.OK);
		}
		catch(NoResultException e)
		{
			return new ResponseEntity<Placement>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/placementservice/{id}")
	public void delete(@PathVariable Integer id)
	{
		pla.delete(id);
	}
	@PutMapping("/placementservice/{id}")
	public ResponseEntity<Placement> update(@PathVariable Integer id,@RequestBody Placement update_p)
	{
		try
		{
			Placement exist_p=pla.get(id);
			exist_p.setName(update_p.getName());
			exist_p.setDept(update_p.getDept());
			exist_p.setMobileno(update_p.getMobileno());
			exist_p.setAddress(update_p.getAddress());
			pla.update(exist_p);
			return new ResponseEntity<Placement>(exist_p,HttpStatus.OK);
		}
		catch(NoResultException e)
		{
			return new ResponseEntity<Placement>(HttpStatus.NOT_FOUND);
		}
	}
}
