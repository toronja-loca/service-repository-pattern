package service;

import models.Register;
import repository.RegisterRepository;

import java.util.List;

public class RegisterService{
        private static RegisterRepository registerRepository ;

        public RegisterService() {
            registerRepository = new RegisterRepository();
        }

        public void save(Register register){
            registerRepository.save(register);
        }

        public void update(Register register){
            registerRepository.update(register);
        }

        public Register getById(int id ){
            return registerRepository.findById(id);
        }

        public void delete(int id){
            Register register = registerRepository.findById(id);
            registerRepository.delete(register);
        }

        public List<Register> findAll(){
            return registerRepository.findAll();
        }

        public void deleteAll(){
            registerRepository.deleteAll();
        }
}
