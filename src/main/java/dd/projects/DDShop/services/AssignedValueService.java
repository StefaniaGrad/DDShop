package dd.projects.DDShop.services;

import dd.projects.DDShop.DTOs.AssignedValueGetDTO;
import dd.projects.DDShop.enitities.AssignedValue;
import dd.projects.DDShop.mapperss.AssignedValueMapperImpl;
import dd.projects.DDShop.repositories.AssignedValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssignedValueService {

    @Autowired
    private final AssignedValueRepository assignedValueRepository;

    @Autowired
    private AssignedValueMapperImpl assignedValueMapper;

    public AssignedValueService(AssignedValueRepository assignedValueRepository) {
        this.assignedValueRepository = assignedValueRepository;
    }

    public void save (AssignedValue assignedValue)
    {
        assignedValueRepository.save(assignedValue);
    }

    public List<AssignedValueGetDTO> getAllAssignedValues(){
        return assignedValueRepository.findAll().stream().map(assignedValue -> assignedValueMapper.AssignedValueToAssignedValueGetDTO(assignedValue)).collect(Collectors.toList());
    }
}
