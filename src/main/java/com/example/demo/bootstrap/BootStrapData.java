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
            ProgressFlagRibbon.setMinInv(1);
            ProgressFlagRibbon.setMaxInv(200);
            partRepository.save(ProgressFlagRibbon);

            InhousePart TransFlagRibbon = new InhousePart();
            TransFlagRibbon.setName("Trans Flag Ribbon");
            TransFlagRibbon.setInv(100);
            TransFlagRibbon.setPrice(1.0);
            TransFlagRibbon.setId(2);
            TransFlagRibbon.setMinInv(1);
            TransFlagRibbon.setMaxInv(200);
            partRepository.save(TransFlagRibbon);

            InhousePart Cellophane = new InhousePart();
            Cellophane.setName("Cellophane");
            Cellophane.setInv(150);
            Cellophane.setPrice(1.0);
            Cellophane.setId(3);
            Cellophane.setMinInv(1);
            Cellophane.setMaxInv(200);
            partRepository.save(Cellophane);

            InhousePart MediumBasket = new InhousePart();
            MediumBasket.setName("Medium Basket");
            MediumBasket.setInv(100);
            MediumBasket.setPrice(5.0);
            MediumBasket.setId(4);
            MediumBasket.setMinInv(1);
            MediumBasket.setMaxInv(200);
            partRepository.save(MediumBasket);

            InhousePart LargeBasket = new InhousePart();
            LargeBasket.setName("Large Basket");
            LargeBasket.setInv(150);
            LargeBasket.setPrice(8.0);
            LargeBasket.setId(5);
            LargeBasket.setMinInv(1);
            LargeBasket.setMaxInv(200);
            partRepository.save(LargeBasket);

            //creating the outsourced parts for the gift baskets
            OutsourcedPart Worthy = new OutsourcedPart();
            Worthy.setName("Worthy at Every Size Frankie Sticker");
            Worthy.setInv(200);
            Worthy.setPrice(4.0);
            Worthy.setId(6);
            Worthy.setMinInv(1);
            Worthy.setMaxInv(500);
            partRepository.save(Worthy);

            OutsourcedPart Joy = new OutsourcedPart();
            Joy.setName("Always Seek Joy Sticker");
            Joy.setInv(200);
            Joy.setPrice(4.0);
            Joy.setId(7);
            Joy.setMinInv(1);
            Joy.setMaxInv(500);
            partRepository.save(Joy);

            OutsourcedPart EveryBODY = new OutsourcedPart();
            EveryBODY.setName("EveryBODY Deserves Me Time Sticker");
            EveryBODY.setInv(200);
            EveryBODY.setPrice(4.0);
            EveryBODY.setId(8);
            EveryBODY.setMinInv(1);
            EveryBODY.setMaxInv(500);
            partRepository.save(EveryBODY);

            OutsourcedPart TakeUpSpace = new OutsourcedPart();
            TakeUpSpace.setName("Take Up Space Kris");
            TakeUpSpace.setInv(200);
            TakeUpSpace.setPrice(4.0);
            TakeUpSpace.setId(9);
            TakeUpSpace.setMinInv(1);
            TakeUpSpace.setMaxInv(500);
            partRepository.save(TakeUpSpace);

            OutsourcedPart Planter= new OutsourcedPart();
            Planter.setName("Frankie Planter");
            Planter.setInv(100);
            Planter.setPrice(44.0);
            Planter.setId(5);
            Planter.setMinInv(1);
            Planter.setMaxInv(200);
            partRepository.save(Planter);

            OutsourcedPart TFlagCandle = new OutsourcedPart();
            TFlagCandle.setName("T-Flag Candle");
            TFlagCandle.setInv(75);
            TFlagCandle.setPrice(35.0);
            TFlagCandle.setId(6);
            TFlagCandle.setMinInv(1);
            TFlagCandle.setMaxInv(100);
            partRepository.save(TFlagCandle);

            OutsourcedPart Imperfect = new OutsourcedPart();
            Imperfect.setName("6 months subscription to the Imperfect  Candle Club");
            Imperfect.setInv(75);
            Imperfect.setPrice(120.0);
            Imperfect.setId(6);
            Imperfect.setMinInv(1);
            Imperfect.setMaxInv(100);
            partRepository.save(Imperfect);

            OutsourcedPart QJoy = new OutsourcedPart();
            QJoy.setName("Queer Joy Cannot Be Legislated Away Sticker");
            QJoy.setInv(75);
            QJoy.setPrice(4.0);
            QJoy.setId(6);
            QJoy.setMinInv(1);
            QJoy.setMaxInv(100);
            partRepository.save(QJoy);

            OutsourcedPart BeNice = new OutsourcedPart();
            BeNice.setName("Please Be Nice To Me Color Block Bucket Hat");
            BeNice.setInv(75);
            BeNice.setPrice(30.0);
            BeNice.setId(6);
            BeNice.setMinInv(1);
            BeNice.setMaxInv(100);
            partRepository.save(BeNice);

            OutsourcedPart Button = new OutsourcedPart();
            Button.setName("Feminism Is For Everyone Button");
            Button.setInv(75);
            Button.setPrice(2.50);
            Button.setId(6);
            Button.setMinInv(1);
            Button.setMaxInv(100);
            partRepository.save(Button);

            OutsourcedPart FTs = new OutsourcedPart();
            FTs.setName("Fvck Transphobes Sticker");
            FTs.setInv(300);
            FTs.setPrice(2.99);
            FTs.setId(6);
            FTs.setMinInv(1);
            FTs.setMaxInv(500);
            partRepository.save(FTs);

            OutsourcedPart FTs = new OutsourcedPart();
            FTs.setName("Fvck Transphobes Sticker");
            FTs.setInv(300);
            FTs.setPrice(2.99);
            FTs.setId(6);
            FTs.setMinInv(1);
            FTs.setMaxInv(500);
            partRepository.save(FTs);

            OutsourcedPart Needed = new OutsourcedPart();
            Needed.setName("Be Who You Needed T-Shirt");
            Needed.setInv(75);
            Needed.setPrice(40.0);
            Needed.setId(6);
            Needed.setMinInv(1);
            Needed.setMaxInv(100);
            partRepository.save(Needed);

            OutsourcedPart AlwaysExisted= new OutsourcedPart();
            AlwaysExisted.setName("LGBTQIA+ People Have Always Existed Pride Tank");
            AlwaysExisted.setInv(150);
            AlwaysExisted.setPrice(35.0);
            AlwaysExisted.setId(6);
            AlwaysExisted.setMinInv(1);
            AlwaysExisted.setMaxInv(200);
            partRepository.save(AlwaysExisted);

            OutsourcedPart EdenBandana = new OutsourcedPart();
            EdenBandana.setName("Eden Bandana");
            EdenBandana.setInv(100);
            EdenBandana.setPrice(10.0);
            EdenBandana.setId(6);
            EdenBandana.setMinInv(1);
            EdenBandana.setMaxInv(200);
            partRepository.save(EdenBandana);

            OutsourcedPart LOKAChaiKit = new OutsourcedPart();
            LOKAChaiKit.setName("Diaspora LOKA Chai Kit");
            LOKAChaiKit.setInv(75);
            LOKAChaiKit.setPrice(160.0);
            LOKAChaiKit.setId(6);
            LOKAChaiKit.setMinInv(1);
            LOKAChaiKit.setMaxInv(100);
            partRepository.save(LOKAChaiKit);

            OutsourcedPart TomorrowWillBeDifferent = new OutsourcedPart();
            TomorrowWillBeDifferent.setName("Tomorrow Will Be Different by Sarah McBride");
            TomorrowWillBeDifferent.setInv(75);
            TomorrowWillBeDifferent.setPrice(18.0);
            TomorrowWillBeDifferent.setId(6);
            TomorrowWillBeDifferent.setMinInv(1);
            TomorrowWillBeDifferent.setMaxInv(100);
            partRepository.save(TomorrowWillBeDifferent);

            OutsourcedPart EuphoriaCoffee = new OutsourcedPart();
            EuphoriaCoffee.setName("Euphoria Coffee");
            EuphoriaCoffee.setInv(100);
            EuphoriaCoffee.setPrice(19.0);
            EuphoriaCoffee.setId(6);
            EuphoriaCoffee.setMinInv(1);
            EuphoriaCoffee.setMaxInv(200);
            partRepository.save(EuphoriaCoffee);

            OutsourcedPart LavenderSamplerTea = new OutsourcedPart();
            LavenderSamplerTea.setName("Sampler of Most popular Lavender Lovelies Tea");
            LavenderSamplerTea.setInv(100);
            LavenderSamplerTea.setPrice(12.0);
            LavenderSamplerTea.setId(6);
            LavenderSamplerTea.setMinInv(1);
            LavenderSamplerTea.setMaxInv(200);
            partRepository.save(LavenderSamplerTea);

            OutsourcedPart Calming = new OutsourcedPart();
            Calming.setName("Calming Kit");
            Calming.setInv(75);
            Calming.setPrice(12.0);
            Calming.setId(6);
            Calming.setMinInv(1);
            Calming.setMaxInv(100);
            partRepository.save(Calming);

            OutsourcedPart TasteTheRainbow = new OutsourcedPart();
            TasteTheRainbow.setName("Taste The Rainbow Pride Cookie Brookie Box");
            TasteTheRainbow.setInv(100);
            TasteTheRainbow.setPrice(12.0);
            TasteTheRainbow.setId(6);
            TasteTheRainbow.setMinInv(1);
            TasteTheRainbow.setMaxInv(200);
            partRepository.save(TasteTheRainbow);

            OutsourcedPart TransJoy= new OutsourcedPart();
            TransJoy.setName("All the Things They Said We Couldn't Have: Stories of Trans Joy");
            TransJoy.setInv(75);
            TransJoy.setPrice(12.0);
            TransJoy.setId(6);
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
