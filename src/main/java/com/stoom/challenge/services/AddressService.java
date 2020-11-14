package com.stoom.challenge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stoom.challenge.entities.Address;
import com.stoom.challenge.repositories.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository repository;

	public List<Address> findAll() {
		return repository.findAll();
	}

	public Address findById(Long id) {
		Optional<Address> obj = repository.findById(id);
		return obj.get();
	}

	public Address insert(Address obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Address update(Long id, Address obj) {
		Address entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Address entity, Address obj) {
		entity.setStreetName(obj.getStreetName());
		entity.setNumber(obj.getNumber());
		entity.setComplement(obj.getComplement());
		entity.setNeighbourhood(obj.getNeighbourhood());
		entity.setCity(obj.getCity());
		entity.setState(obj.getState());
		entity.setCountry(obj.getCountry());
		entity.setZipcode(obj.getZipcode());
		entity.setLatitude(obj.getLatitude());
		entity.setLongitude(obj.getLongitude());

	}

}
