package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }


        if(partRepository.count() == 0) {
            //creating the in-house parts for the gift baskets
            InhousePart ProgressFlagRibbon = new InhousePart();
            ProgressFlagRibbon.setName("Progress Flag Ribbon");
            ProgressFlagRibbon.setInv(100);
            ProgressFlagRibbon.setPrice(1.0);
            ProgressFlagRibbon.setId(1);
            //ProgressFlagRibbon.setMinInv(1);
            //ProgressFlagRibbon.setMaxInv(200);
            partRepository.save(ProgressFlagRibbon);

            InhousePart TransFlagRibbon = new InhousePart();
            TransFlagRibbon.setName("Trans Flag Ribbon");
            TransFlagRibbon.setInv(100);
            TransFlagRibbon.setPrice(1.0);
            TransFlagRibbon.setId(2);
            //TransFlagRibbon.setMinInv(1);
            //TransFlagRibbon.setMaxInv(200);
            partRepository.save(TransFlagRibbon);

            InhousePart Cellophane = new InhousePart();
            Cellophane.setName("Cellophane");
            Cellophane.setInv(150);
            Cellophane.setPrice(1.0);
            Cellophane.setId(3);
            //Cellophane.setMinInv(1);
            //Cellophane.setMaxInv(200);
            partRepository.save(Cellophane);

            InhousePart MediumBasket = new InhousePart();
            MediumBasket.setName("Medium Basket");
            MediumBasket.setInv(100);
            MediumBasket.setPrice(5.0);
            MediumBasket.setId(4);
            //MediumBasket.setMinInv(1);
            //MediumBasket.setMaxInv(200);
            partRepository.save(MediumBasket);

            InhousePart LargeBasket = new InhousePart();
            LargeBasket.setName("Large Basket");
            LargeBasket.setInv(150);
            LargeBasket.setPrice(8.0);
            LargeBasket.setId(5);
            //LargeBasket.setMinInv(1);
            //LargeBasket.setMaxInv(200);
            partRepository.save(LargeBasket);

            //creating the outsourced parts for the gift baskets
            OutsourcedPart Worthy = new OutsourcedPart();
            Worthy.setName("Worthy at Every Size Frankie Sticker");
            Worthy.setInv(200);
            Worthy.setPrice(4.0);
            Worthy.setId(1);
            //Worthy.setMinInv(1);
            //Worthy.setMaxInv(500);
            partRepository.save(Worthy);
        }

        if (productRepository.count() == 0) {
            //creating the products - gift baskets
            Product TheT = new Product("The T - Gift Basket", 75.0, 20);
            Product TheAgenda = new Product("The Agenda - Gift Basket", 100.0, 15);
            Product MeTime = new Product("Me Time: Cause You’re Worth It - Basket", 150.0, 10);
            Product Joy = new Product("Joy - Gift Basket", 50.0, 30);
            Product P4Real = new Product("P Realness", 15.0, 25);

            productRepository.save(TheT);
            productRepository.save(TheAgenda);
            productRepository.save(MeTime);
            productRepository.save(Joy);
            productRepository.save(P4Real);
        }



        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
