package team.kasta.bridaya.service.impl;

import org.springframework.stereotype.Service;
import team.kasta.bridaya.model.common.Merchant;
import team.kasta.bridaya.repository.MerchantRepository;
import team.kasta.bridaya.service.MerchantService;

@Service
public class MerchantServiceImpl implements MerchantService {

    private final MerchantRepository merchantRepository;

    public MerchantServiceImpl(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    @Override
    public Merchant createMerchant(Merchant merchant) {
        return merchantRepository.save(merchant);
    }
}
