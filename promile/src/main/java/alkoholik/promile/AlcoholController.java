package alkoholik.promile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AlcoholController {

    //@GetMapping('/hello')
    //Sciezka serwera localhost:8080/hello
    //Sciezka serwera localhost:8080/

    @GetMapping("/")
    public String home(){
        return "alcohol";// zwroc plik alcohol.html z folderu: resorces/templates
    }


    private AlcoholCounter alcoholCounter=new AlcoholCounter();

    @GetMapping("/result")
    public String getResult(
            @RequestParam Double quantity,
            @RequestParam Double weight,
            @RequestParam String alcohol, ModelMap modelMap
            ){
        Alcohol alcoholEnum =Alcohol.valueOf(alcohol);
        System.out.println("WARTOSCI: "+quantity+" "+weight+" "+alcohol);

        float result= alcoholCounter.calculatePerMil(quantity*1000,weight,true,alcoholEnum);

        System.out.println("Promile "+alcoholCounter.calculatePerMil(quantity,weight,true,alcoholEnum));
        String resultString= String.format("%.2f",result);
        modelMap.put("result",resultString);
        return "result";
    }
}
