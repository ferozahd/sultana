package com.tutorial.sultana.service.impl;

import com.tutorial.sultana.entities.Persons;
import com.tutorial.sultana.exceptions.DateNotFoundException;
import com.tutorial.sultana.exceptions.InvalidConversion;
import com.tutorial.sultana.mapper.PersonMapper;
import com.tutorial.sultana.moduls.person.PersonGetResources;
import com.tutorial.sultana.moduls.person.PostResource;
import com.tutorial.sultana.repo.PersonRepo;
import com.tutorial.sultana.service.PersonService;
import com.tutorial.sultana.utils.VariableUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonMapper personMapper;
    private final PersonRepo personRepo;

    /*
    * this part we just featch all data from person collection
    * and We will parse it to @class PersonGetResourece
    * */

    @Override
    public List<PersonGetResources> findAll()  {
      return personRepo.findAll().stream().map(p->personMapper.toGetResource(p)).collect(Collectors.toList());
    }

    @Override
    public PersonGetResources getOne(String id) {
        Optional<Persons> persons=personRepo.findById(VariableUtils.toObjectId(id));
        if(persons.isPresent()) {
            return personMapper.toGetResource(persons.get());
        }
        throw new DateNotFoundException("this is id not available");
    }



    @Override
    public PersonGetResources create(PostResource post) {
        Persons persons = personMapper.toPerson(post);
        personRepo.save(persons);
        return personMapper.toGetResource(persons);
    }
}
