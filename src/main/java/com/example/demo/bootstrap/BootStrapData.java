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
            InhousePart TransFlagRibbon = new InhousePart();
            TransFlagRibbon.setName("Trans Flag Ribbon");
            TransFlagRibbon.setInv(100);
            TransFlagRibbon.setPrice(1.0);
            TransFlagRibbon.setId(1);
            TransFlagRibbon.setMinInv(1);
            TransFlagRibbon.setMaxInv(200);
            partRepository.save(TransFlagRibbon);

            InhousePart Basket = new InhousePart();
            Basket.setName("Basket with Cellophane");
            Basket.setInv(150);
            Basket.setPrice(8.0);
            Basket.setId(2);
            Basket.setMinInv(1);
            Basket.setMaxInv(200);
            partRepository.save(Basket);

            //creating the outsourced parts for the gift baskets
            OutsourcedPart Joy = new OutsourcedPart();
            Joy.setName("Always Seek Joy Sticker");
            Joy.setCompanyName("ctoanco.com");
            Joy.setInv(200);
            Joy.setPrice(4.0);
            Joy.setId(3);
            Joy.setMinInv(1);
            Joy.setMaxInv(500);
            partRepository.save(Joy);

            OutsourcedPart TomorrowWillBeDifferent = new OutsourcedPart();
            TomorrowWillBeDifferent.setName("Tomorrow Will Be Different by Sarah McBride");
            TomorrowWillBeDifferent.setCompanyName("allshewrotebooks.com/product-page/tomorrow-will-be-different-by-sarah-mcbride");
            TomorrowWillBeDifferent.setInv(75);
            TomorrowWillBeDifferent.setPrice(18.0);
            TomorrowWillBeDifferent.setId(5);
            TomorrowWillBeDifferent.setMinInv(1);
            TomorrowWillBeDifferent.setMaxInv(100);
            partRepository.save(TomorrowWillBeDifferent);

            OutsourcedPart TransJoy= new OutsourcedPart();
            TransJoy.setName("All the Things They Said We Couldn't Have: Stories of Trans Joy");
            TransJoy.setCompanyName("spectrumoutfitters.us/collections/books/products/all-the-things-they-said-we-couldnt-have-stories-of-trans-joy-t-c-oaks-monger-illustrated-by-flatboy");
            TransJoy.setInv(75);
            TransJoy.setPrice(12.0);
            TransJoy.setId(7);
            TransJoy.setMinInv(1);
            TransJoy.setMaxInv(100);
            partRepository.save(TransJoy);

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
