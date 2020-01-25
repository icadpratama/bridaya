package team.kasta.bridaya.service.impl;

import org.springframework.stereotype.Service;
import team.kasta.bridaya.model.common.Business;
import team.kasta.bridaya.repository.BusinessRepository;
import team.kasta.bridaya.service.BusinessService;

@Service
public class BusinessServiceImpl implements BusinessService {

    private BusinessRepository businessRepository;

    public BusinessServiceImpl(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    @Override
    public Business createBusiness(Business business) {
        return businessRepository.save(business);
    }
}
