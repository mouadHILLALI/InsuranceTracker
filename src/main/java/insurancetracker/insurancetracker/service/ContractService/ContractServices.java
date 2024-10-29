    package insurancetracker.insurancetracker.service.ContractService;

    import insurancetracker.insurancetracker.dtos.ContractDto;
    import insurancetracker.insurancetracker.model.*;
    import insurancetracker.insurancetracker.repository.ContractRepository;
    import insurancetracker.insurancetracker.repository.InsuranceRepository;
    import jakarta.transaction.Transactional;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.Optional;

    @Service
    public class ContractServices {
        @Autowired
        private ContractRepository contractRepository;
        @Autowired
        private InsuranceRepository insuranceRepository;
        @Transactional
        public boolean addCarContract(ContractDto contractDto , AutoInsurance carInsurance) {
            try {
                AutoInsurance insurance = (AutoInsurance) insuranceRepository.findById(carInsurance.getPolicyNumber()).orElse(null);
                Contract contract = new Contract(contractDto.getJustification() , insurance , contractDto.getTotal());
                contract = contractRepository.save(contract);
                if (contract != null) {
                    return true;
                }else{
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        @Transactional
        public boolean addHealthContract(ContractDto contractDto , HealthInsurance healthInsurance) {
        try {
            HealthInsurance insurance = (HealthInsurance) insuranceRepository.findById(healthInsurance.getPolicyNumber()).orElse(null);
            Contract contract = new Contract(contractDto.getJustification() , insurance , contractDto.getTotal());
            contract = contractRepository.save(contract);
            if (contract != null) {
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
        @Transactional
        public boolean addHomeContract(ContractDto contractDto , HomeInsurance homeInsurance) {
        try {
            HomeInsurance insurance = (HomeInsurance) insuranceRepository.findById(homeInsurance.getPolicyNumber()).orElse(null);
            Contract contract = new Contract(contractDto.getJustification() , insurance , contractDto.getTotal());
            contract = contractRepository.save(contract);
            if (contract != null) {
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    }
