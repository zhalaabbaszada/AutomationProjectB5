package io.loop.test.day9;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class T5_java_faker {
@Test
    public void java_faker(){
    Faker faker = new Faker();

    System.out.println("faker.name().fullName() = " + faker.name().fullName());

    System.out.println("faker.numerify(\"222-###-####\") = " + faker.numerify("222-###-####"));
    System.out.println("faker.letterify(\"????????????????\") = " + faker.letterify("????????????????"));
    System.out.println("faker.bothify(\"###???###???\") = " + faker.bothify("###???###???"));
    System.out.println("faker.address().fullAddress() = " + faker.address().fullAddress());
    System.out.println("faker.finance().creditCard(CreditCardType.VISA) = " + faker.finance().creditCard(CreditCardType.VISA));
    System.out.println("faker.chuckNorris().fact().replace(\"Chuck Norris\", \"Feyruz\") = " + faker.chuckNorris().fact().replace("Chuck Norris", "Feyruz"));
}
}
