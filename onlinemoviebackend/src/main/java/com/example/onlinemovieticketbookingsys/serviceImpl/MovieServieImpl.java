package com.example.onlinemovieticketbookingsys.serviceImpl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.onlinemovieticketbookingsys.beans.Movie;
import com.example.onlinemovieticketbookingsys.beans.Show;
import com.example.onlinemovieticketbookingsys.exceptions.MovieNotFoundException;
import com.example.onlinemovieticketbookingsys.repository.MovieRepo;
import com.example.onlinemovieticketbookingsys.service.MovieService;

@Service
public class MovieServieImpl implements MovieService {

	@Autowired
	private MovieRepo repo;
	
	@Override
	public Movie addMovie(Movie m,MultipartFile image)throws Exception {
		
		String uploadDir=System.getProperty("user.dir")+ "/uploads";
		
		File dir=new File(uploadDir);
		
		if(!dir.exists())
		{
			dir.mkdirs();
		}
		
		if(image !=null && !image.isEmpty()) {
			//yaha pe new image save hogi
			//yaha pe image ka filename get hoga
			String filename=image.getOriginalFilename();
			
			Path filePath=Path.of(uploadDir,filename);
			Files.write(filePath, image.getBytes());
			
			//image transfer hogi uploads file mai
//			image.transferTo(
//					new File(uploadDir+"/"+filename)
//					);
			
			
			m.setImageName(filename);
		}else {
			//yaha pe agr new image nahi dalni tho old wali hi rahegi
			Movie existing =repo.findById(m.getId()).orElseThrow();
			m.setImageName(existing.getImageName()); // purana image rakho
		}
		
		
		
		
		
		return repo.save(m);	
	}

	@Override
	public List<Movie> getMovie() {
		
		return repo.findAll();
	}
	
	@Override
	public List<Movie> getActivateMovie() {
		
		return repo.findByActiveTrue();
	}

	@Override
	public Movie getByID(int id) {
		
		return repo.findById(id).orElseThrow(()->
		new MovieNotFoundException("Movie not found with id ", id));
	}

	
//	public void deletMovie(int id)
//	{
//		repo.deleteById(id);
//	}
	
	public Movie deactivateMovie(int id)
	{
		Movie sh=repo.findById(id).orElseThrow();
		sh.setActive(!sh.isActive());
		return repo.save(sh);
		
	}
	

}
