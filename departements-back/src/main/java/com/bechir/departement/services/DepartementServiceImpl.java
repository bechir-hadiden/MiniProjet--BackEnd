package com.bechir.departement.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bechir.departement.College;
import com.bechir.departement.Departement;
import com.bechir.departement.DepartementDTO;
import com.bechir.departement.Image;
import com.bechir.departement.repos.DepartementRepository;
import com.bechir.departement.repos.ImageRepository;

@Service
public class DepartementServiceImpl implements DepartementServices {
	@Autowired
	ModelMapper modelMapper;

	@Autowired
	DepartementRepository departementRepository;

	
	@Autowired
	ImageRepository imageRepository;
	
	@Override
	public void deleteDepartementById(Long id) {

		departementRepository.deleteById(id);
	}

	@Override
	public void deleteDepartement(Departement p) {
		departementRepository.delete(p);
	}

//	@Override
//	public Departement updateDepartement(Departement departement) {
////			return convertEntityToDto(departementRepository.save(convertDtoToEntity(departement)));
//
//		Departement departementEntity = convertDtoToEntity(departement);
//
//		// Sauvegarde / mise à jour de l'entité
//		Departement updatedDepartement = departementRepository.save(departementEntity);
//
//		// Conversion Entité -> DTO pour le retour
//		return convertEntityToDto(updatedDepartement);
//
//	}

	@Override
	public Departement updateDepartement(Departement p) {
		
		
//		Long oldEvntImageId = this.getDepartement(p.getIdDepartement()).get().getIdImage();
//		Long newEventImageID = p.getImages().g();
//			Departement eventUpdated = departementRepository.save(p);
//			if (oldEvntImageId != newEventImageID)
//				imageRepository.deleteById(newEventImageID);
//			return eventUpdated;
//		}

		Departement depar = departementRepository.save(p);
		return depar ; 

	}

	@Override
	public List<Departement> findByNomDepartement(String nom) {

		return findByNomDepartement(nom);
	}

	@Override
	public List<Departement> findByNomDepartementContains(String nomDepartement) {
		return departementRepository.findByNomDepartementContains(nomDepartement);
	}

	@Override
	public List<Departement> findByNomNombre(String nom, int nombre) {

		return findByNomNombre(nom, nombre);
	}

	@Override
	public List<Departement> findByCollege(College college) {
		return findByCollege(college);
	}

	@Override
	public List<Departement> findByCollegeIdcol(Long id) {
		// TODO Auto-generated method stub
		return departementRepository.findByCollegeIdcol(id);
	}

	@Override
	public List<Departement> findByOrderByNomDepartementAsc() {
		return findByOrderByNomDepartementAsc();
	}

	@Override
	public List<Departement> trierDepartementsNomsNombre() {
		return trierDepartementsNomsNombre();
	}

	@Override
	public Departement convertEntityToDto(Departement departement) {

		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Departement departements = modelMapper.map(departement, Departement.class);
		return departements;
	}

	@Override
	public Departement saveDepartement(Departement departement) {

		return convertEntityToDto(departementRepository.save(convertDtoToEntity(departement)));

	}

	@Override
	public Departement getDepartement(Long id) {
		return convertEntityToDto(departementRepository.findById(id).get());
	}

	@Override
	public List<Departement> getAllDepartements() {
		return departementRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
	}

	@Override
	public Departement convertDtoToEntity(Departement DepartementDto) {
		Departement departement = new Departement();
		departement = modelMapper.map(DepartementDto, Departement.class);
		return departement;
	}

	
	


}
