package com.example.loginpage;



import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.util.ArrayList;

public class FragmentsActivity extends AppCompatActivity implements ListFrag.ItemSelected{

    TextView tvDescription;
    public ArrayList<String> descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_fragments);

        tvDescription=findViewById(R.id.tvDescription);

        tvDescription.setMovementMethod(new ScrollingMovementMethod());

        descriptions= new ArrayList<String>();

        descriptions.add("     FASCINATING AND STRANGE FACTS ABOUT WATER\n" +
                "\n" +
                "\n" +
                "1. There are about 1.5 billion cubic kilometres of water on Earth – that's 1.5 billion trillion litres, or 800 trillion Olympic swimming pools.\n" +
                "\n" +
                "2. If all that water was evenly spread over the Earth's surface it would have a depth of 3,700 metres.\n" +
                "\n" +
                "3. 97% of the Earth's water is salty. 2.1% is locked up in polar ice caps and less than 1% is available as fresh water.\n" +
                "\n" +
                "\n" +
                "4. Water is sticky. The molecules love to stick to things, especially each other. It's what gives it such a large surface tension. It keeps you alive: it means water can pull blood up narrow vessels in the body, often against the force of gravity.\n" +
                "\n" +
                "5. Water should be a gas at room temperature – all similar molecules, such as hydrogen sulphide (H2S) and ammonia (NH3), are gases. The stickiness of water molecules holds them together as a liquid.\n" +
                "\n" +
                "6. Water is the second most common molecule in the universe. The most common is hydrogen gas, H2.\n" +
                "\n" +
                "7. The biggest known cloud of water vapour was discovered by Nasa scientists around a black hole 12 billion light years from Earth. There is 140 trillion times as much water in it as all the water in the world's oceans.\n" +
                "\n" +
                "8. All the water on Earth arrived in comets and asteroids. It happened between 4.5bn and 3.8bn years ago, a period called the Late Heavy Bombardment.\n" +
                "\n" +
                "9. The Antarctic has been covered in ice for more than 30m years. Right now, it is covered by 10 thousand trillion tons of snow and ice.\n" +
                "\n" +
                "10. There is ice on the poles of the moon, and on the poles of Mars and Mercury.\n" +
                "\n" +
                "11. There are at least 16 different kinds, or \"phases\", of ice. All of them have different crystal structures.\n" +
                "\n" +
                "12. The Sun and other stars like it create the equivalent of 100 million times the water in the Amazon river every second.\n" +
                "\n" +
                "13. Your body is between 60% and 70% water. This changes at different times of your life: a human foetus is around 95% water for the first months, getting to 77% water at birth. In a 70kg person, there are 42 litres of water.\n" +
                "\n" +
                "14. Two-thirds of that water is within your cells.\n" +
                "\n" +
                "15. We each drink around 1 cubic metre (1000 litres) of water a year.\n" +
                "\n" +
                "16. Water expands when it freezes, unlike almost every other liquid. This has been crucial to life – lakes and rivers freeze from the top down, so even though the Earth has faced successive ice ages, there has always been liquid water for life to continue evolving.\n" +
                "\n" +
                "17. Hot water freezes faster than cold water. This is known as the Mpemba Effect, and no-one knows why it happens.\n" +
                "\n" +
                "18. A five-minute shower uses 200 litres of water.\n" +
                "\n" +
                "19.You use 8 litres to flush a toilet – about the same as you use to brush your teeth.\n" +
                "\n" +
                "20. It takes 200 litres of water to produce the coffee beans for one cup of coffee\n" +
                "\n" +
                "21. It takes 15,000 litres of water to produce 1 kg of beef.\n" +
                "\n" +
                "22. It takes 100 litres to make 2 slices of bread and 65 litres to make the cheese filling in your sandwich.\n" +
                "\n" +
                "23. It takes 150 litres of water to make one pint (568ml) of beer\n" +
                "\n" +
                "24. A kilo of cotton – enough for a shirt and a pair of jeans – needs 10,000 litres of water to produce.\n" +
                "\n" +
                "25. Everywhere there is liquid water on Earth, there is life. Even if that water is nearly boiling, or the area is skin-burningly acidic.\n" +
                "\n" +
                "27. There is a hot ocean under the ice crust of Saturn’s moon Enceladus, probably sitting on a bed of rock. Since a hydrothermal vent at the bottom of one of the Earth’s oceans is thought to be the best candidate for where life started on our planet, astrobiologists think Enceladus is a good place to look for alien life.\n" +
                "\n");

        descriptions.add("BENEFITS OF DRINKING WATER\n" +          "\n" +
                "Possible benefits of drinking water range from keeping the kidneys healthy to losing weight.\n" +
                "To function properly, all the cells and organs of the body need water.\n" +
                "\n" +
                "Here are some reasons our body needs water:\n" +
                "\n" +
                "1. It lubricates the joints\n" +
                "\n" +
                "Cartilage, found in joints and the disks of the spine, contains around 80 percent water. Long-term dehydration can reduce the joints' shock-absorbing ability, leading to joint pain.\n" +
                "\n" +
                "2. It forms saliva and mucus\n" +
                "\n" +
                "Saliva helps us digest our food and keeps the mouth, nose, and eyes moist. This prevents friction and damage. Drinking water also keeps the mouth clean. Consumed instead of sweetened beverages, it can also reduce tooth decay.\n" +
                "\n" +
                "3. It delivers oxygen throughout the body\n" +
                "\n" +
                "Blood is more than 90 percent water, and blood carries oxygen to different parts of the body.\n" +
                "\n" +
                "4. It boosts skin health and beauty\n" +
                "\n" +
                "With dehydration, the skin can become more vulnerable to skin disorders and premature wrinkling.\n" +
                "\n" +
                "5. It cushions the brain, spinal cord, and other sensitive tissues\n" +
                "\n" +
                "Dehydration can affect brain structure and function. It is also involved in the production of hormones and neurotransmitters. Prolonged dehydration can lead to problems with thinking and reasoning.\n" +
                "\n" +
                "6. It regulates body temperature\n" +
                "\n" +
                "Water that is stored in the middle layers of the skin comes to the skin's surface as sweat when the body heats up. As it evaporates, it cools the body. In sport.\n" +
                "\n" +
                "Some scientists have suggested that when there is too little water in the body, heat storage increases and the individual is less able to tolerate heat strain.\n" +
                "\n" +
                "Having a lot of water in the body may reduce physical strain if heat stress occurs during exercise. However, more research is needed into these effects.\n" +
                "\n" +
                "7, The digestive system depends on it\n" +
                "\n" +
                "The bowel needs water to work properly. Dehydration can lead to digestive problems, constipation, and an overly acidic stomach. This increases the risk of heartburn and stomach ulcers.\n" +
                "\n" +
                "8. It flushes body waste\n" +
                "\n" +
                "Water is needed in the processes of sweating and removal of urine and feces.\n" +
                "\n" +
                "9. It helps maintain blood pressure\n" +
                "\n" +
                "A lack of water can cause blood to become thicker, increasing blood pressure.\n" +
                "\n" +
                "10. The airways need it\n" +
                "\n" +
                "When dehydrated, airways are restricted by the body in an effort to minimize water loss. This can make asthma and allergies worse.\n" +
                "\n" +
                "11. It makes minerals and nutrients accessible\n" +
                "\n" +
                "These dissolve in water, which makes it possible for them to reach different parts of the body.\n" +
                "\n" +
                "12. It prevents kidney damage\n" +
                "\n" +
                "The kidneys regulate fluid in the body. Insufficient water can lead to kidney stones and other problems.\n" +
                "\n" +
                "13. It boosts performance during exercise\n" +
                "\n" +
                "Dehydration during exercise \n" +
                "Dehydration during exercise may hinder performance.\n" +
                "Some scientists have proposed that consuming more water might enhance performance during strenuous activity.\n" +
                "\n" +
                "More research is needed to confirm this, but one review found that dehydration reduces performance in activities lasting longer than 30 minutes.\n" +
                "\n" +
                "14. Weight loss\n" +
                "\n" +
                "Water may also help with weight loss, if it is consumed instead of sweetened juices and sodas. \"Preloading\" with water before meals can help prevent overeating by creating a sense of fullness.\n" +
                "\n" +
                "15. It reduces the chance of a hangover\n" +
                "\n" +
                "When partying, unsweetened soda water with ice and lemon alternated with alcoholic drinks can help prevent overconsumption of alcohol.\n" +
                "\n");

        descriptions.add(" It’s easy to overlook, but making sure we drink enough water is often quite low on our priority list.\n" +
                "\n" +
                "But are we putting ourselves at grave risk by doing so?\n" +
                "\n" +
                "“Your immune system relies on water,” says Dr Marilyn Glenville, author of Natural Alternatives to Sugar. “It carries nutrients to the cells, carries waste and toxins away from the cells and out of the body, keeps body temperature stable, protects joints and keeps the lining of your mouth hydrated and moist, reducing susceptibility to colds.\n" +
                "\n" +
                "“Drinking plenty of water will also flush out waste and dilute mucus, helping eliminate bacteria and viruses that can make you ill.”\n" +
                "\n" +
                "And here are the surprising side effects of forgetting to drink water.\n" +
                "\n" +
                "1. You are feeling tired\n" +
                "Our bodily fluids are comprised of water so when you get dehydrated, your blood becomes thicker and your heart has to use more energy to keep oxygen and other nutrients moving through the circulatory system.\n" +
                "\n" +
                "“The body’s way of conserving energy as it may not be functioning as efficiently in a hypo-hydrated state,” says Dr Emma Derbyshire of Natural Hydration Council.\n" +
                "\n" +
                "The Natural Hydration Council says one in 10 cases of tiredness are attributed to dehydration.\n" +
                "\n" +
                "2. You are having digestive problems\n" +
                "“We all know that fibre is an essential nutrient in the digestive process, but without enough water, it can easily lead to constipation,” says Dr Adam Simon, chief medical officer at PushDoctor.co.uk.\n" +
                "\n" +
                "“Simply put, water makes it easier for you to go the toilet, softening your poo so that it’s easier to pass.\n" +
                "\n" +
                "“Some studies have also claimed that not drinking enough water makes it more likely that you’ll develop stomach ulcers.”\n" +
                "\n" +
                "3. Your eyes are sore\n" +

                "Your eyes will become dry, irritated and bloodshot if they don’t get enough water.\n" +
                "\n" +
                "“That’s because they’re usually protected by a thin film of moisture which, like your tears, contains water and salt,” says Dr Simon.\n" +
                "\n" +
                "“If the salt isn’t sufficiently diluted, your eyes will feel it. This lack of moisture will also make life particularly miserable for people who wear contact lenses.”\n" +
                "\n" +
                "4. You have an increased risk of kidney stones\n" +

                "“Dehydration can lead to the formation of kidney stones,” says Dr Simon.\n" +
                "\n" +
                "“While most are small and can be passed out by the body, if kidney stones are large enough, they can block the urinary tract and cause stomach or groin pain.\n" +
                "\n" +
                "“If you become severely dehydrated, there’s a chance you could develop acute renal failure.”\n" +
                "\n" +
                "5. You have bad breath\n" +

                "“Keeping hydrated is essential for general wellbeing, but you may be surprised to know it is also essential to keep your breath in check too,” says Luke Thorley, of Welling Corner Dental Practice and brand ambassador for CB12.\n" +
                "\n" +
                "“Regular glasses of water help to maintain saliva flow, which washes away the ‘bad bacteria’ that cause unpleasant breath.”\n" +
                "\n" +
                "6. You have aching joints\n" +
                "Joints need fluid to stay lubricated in order to function.\n" +
                "\n" +
                "“It’s important for your joints to stay lubricated in order for them to work properly,” says Dr Simon.\n" +
                "\n" +
                "“Getting plenty of fluids will help keep cartilage soft, which reduces your chances of developing arthritis or other joint problems.”\n" +
                "\n" +
                "7. You have a headache\n" +
                "“The loss of even 1-2% of body weight – equating to 500 ml to two litres – can bring on headache symptoms,” says Dr Carrie Ruxton, a member of the Tea Advisory Panel.\n" +
                "\n" +
                "“Alongside this, you may feel dizzy or lethargic. Start replacing fluid straight away if a headache comes on by sipping water steadily.”\n" +
                "\n" +
                "8. Your cholesterol levels are higher than normal\n" +
                "Without water, your body will produce more cholesterol in order to ensure your cell membranes stay moist and can continue to process both nutrients and waste products.\n" +
                "\n" +
                "“Of course, we know the dangers of high cholesterol, which can increase your chance of life-threatening problems such as heart attacks and strokes,” Dr Simon adds.\n" +
                "\n" +
                "9. Your concentration levels are falling\n" +
                "Finding it hard to focus at work? Your room may have something to do with it.\n" +
                "\n" +
                "“Stress, long commutes, air conditioning and heating can all increase water loss even when you don’t feel particularly sweaty,” adds Dr Ruxton.\n" +
                "\n" +
                "“The brain represents only 2% of the body’s weight, but gets 20% of blood circulation.\n" +
                "\n" +
                "“That means that dehydration affects the brain far earlier than the body as the brain relies on a steady supply of oxygen and nutrients.”\n" +
                "\n" +
                "10. You are finding simple exercises hard to do\n" +
                "“Physical performance is affected when dehydration hits around 1-3% of body weight, so water should be your most important accessory in the gym,” says Dr Ruxton.\n" +
                "\n" +
                "“When exercising for short periods or at low intensities, a bottle of tap water will do.\n" +
                "\n" +
                "“Longer periods of exercise, around 40-60 minutes, tend to cause losses of salts as well as fluid so a sports drink would be a better option.”");

        descriptions.add("Ever notice how we recommend drinking more water in basically every article on weight loss, health, and fitness? We’d hate to sound like a broken record, but water is imperative for your health. (Our bodies are, in fact, made up of about 60 percent water.) So, it’s not a bad idea to guzzle it and avoid dehydration so that your system functions properly. From stopping belly bloat to warding off diseases, getting enough water is one of the most important things you can do. There are some drastic physiological effects, so it’s better not to find out what happens when you don’t drink enough water.\n" +
                "\n" +
                "Still, some people barely drink any water. And when these water-phobic people do drink, they might drink belly-busting beverages like soda or fruit juice. While you will get some water and hydration from these things—and you can get water from certain water-rich foods—you should still make hydration from plain water a priority.\n" +
                "\n" +
                "Read on to find out more about what can happen if you don’t drink enough water. Fortunately, adding more water to your diet might be easier than you think. It just might take a conscious effort at first.\n" +
                "\n" +
                "1\tYou gain water weight.\n" +
                "Bloated woman putting on jeans - what happens when you dont drink enough water\n" +
                "It sounds counterintuitive, but skimping on drinking water can actually cause water retention and temporary weight gain. “When you’re not drinking enough [water], your body holds every drop to prevent severe dehydration,” says Abbey Sharp, RD.\n" +
                "\n" +
                "2\tYour energy drops.\n" +
                "Feeling groggy? Skip the caffeine and drink water instead. “Yes, you should drink plenty of water during the day to stay hydrated. In fact, even slight dehydration can significantly drain your energy levels,” Erin Palinski-Wade, RD, CDE explains.\n" +
                "\n" +
                "3\tYou lose focus.\n" +
                "The fundamental element of life is also essential to finding great ideas. Made of 80 percent water, your brain’s abilities and functions seriously depend on it. Even slight dehydration impairs its abilities, making any eurekas a challenge. A study in the journal Nutrients found that drinking water can prevent memory and attention decline.\n" +
                "\n" +
                "3\tYour risk of stroke increases.\n" +
                "Not only can dehydration make you take longer for you to recover from a stroke, but it can actually make it worse, according to a study in BMC Cardiovascular Disorders. Not a huge fan of straight, nothing-added water? Try a fruity detox water to hydrate you while giving you an extra squeeze of citrus and other bloat-busters.\n" +
                "\n" +
                "5\tYou get crankier.\n" +
                "Feeling cranky? Forgoing H2O may be the worst thing you could do. Two studies from the University of Connecticut put men and women through a series of cognitive tests and found that even being mildly dehydrated affected their moods and caused fatigue and headaches.\n" +
                "\n" +
                "6\tYou feel hungrier.\n" +
                "It’s very common to confuse hunger with dehydration. If your stomach is growling, your best bet is to drink some water. “Try drinking water and waiting 20 minutes before grabbing that snack you’ve been eyeing,” says nutritionist Amy Shapiro, MS, RD. She also urges replacing sugary drinks like soda, juices, or sports drinks with water.\n" +
                "\n" +
                "7\tYour metabolism tanks.\n" +
                "Nixing water from your diet can seriously derail your weight loss plans, proven by a study from The Journal of Clinical Endocrinology and Metabolism. After drinking approximately 17 ounces of water (about two tall glasses), participants’ metabolic rates increased by 30 percent. The researchers estimate that increasing water intake by 1.5 liters a day (about six cups) would burn an extra 17,400 calories over the course of the year—a weight loss of approximately five pounds!\n" +
                "\n" +
                "8\tYou get headaches.\n" +
                "Before you reach for the Tylenol, try chugging water when your head hurts. The previous study we just mentioned found dehydration can also lead to headaches.\n" +
                "\n" +
                "9\tYour skin worsens.\n" +
                "Water helps to plump up your skin, so you should be able to imagine what dehydration will do. When you don’t drink enough water, the collagen begins to crack and bind together, causing fine lines and wrinkles to get more noticed. We rely on water to keep our insides sufficiently hydrated, too. So when you ditch it, expect your mouth, skin, and everything else to feel drier than normal.\n" +
                "\n" +
                "10\tYour workout performance suffers.\n" +
                "Your body cannot efficiently convert carbs into energy without ample water. And according to The Physiological Society, dehydration can lead to poor exercise performance. Not only will your workout sessions suffer but insufficient liquids in your body will also hold back the breakdown of fat.\n" +
                "\n" +
                "11\tYou have more bathroom troubles.\n" +
                "Can’t poop? Your bathroom schedule is well maintained when your colon absorbs up to five liters of water per day, making it easier to go to the bathroom. But when your body realizes that water is MIA from your system, it absorbs more—which makes it harder to expel waste says Nitin Kumar, MD, a gastroenterologist.\n" +
                "\n" +
                "\n" +
                "12\tYour kidneys will function poorly.\n" +
                "In order for your kidneys to work properly, you need water to dilute the blood. Without enough water, your kidneys have to work overtime to filter out the blood, says Kumar. And severe dehydration can also lead to failure or worse, kidney stones.\n" +
                "\n" +
                "13\tAnd so will your heart.\n" +
                "“When you’re dehydrated, your heart has to work harder to maintain blood flow when you stand up,” Kumar explains. “If you’re sufficiently dehydrated and your heart is not up to this task, the insufficient blood flow to your brain can result in fainting.”\n" +
                "\n" +
                "14\tGuys may Experience erectile dysfunction.\n" +
                "The hard truth? Not drinking enough water may keep a man soft. In a dehydrated state, you produce a greater amount of angiotensin, a type of hormone that is commonly found in men experiencing having difficulty achieving stable erections. Feeling thirsty yet?\n" +
                "\n" +
                "15\tYou stop crying.\n" +
                "A lack of water will stop your tears (but only physically, not emotionally!). “Tear production is decreased when a person is dehydrated from not drinking water. The body tries to create homeostasis or keep fluid balance in check. When there is a decreased amount of fluid intake, the body stores the water to hydrate vital organs first,” says Elissa B. Gartenberg, DO.\n" +
                "\n" +
                "\n" +
                "16\tYour pee changes color.\n" +
                "Ever want to know how well-hydrated are you? Check your pee. When you don’t drink enough water, your urine color will turn into a darker yellow. If you’re severely dehydrated, you might not even pee at all.\n" +
                "\n" +
                "Now that you know what happens when you don’t drink enough water, you can avoid some of these symptoms in the future. Your body will thank you.\n" +
                "\n");

        descriptions.add("In most urban areas, water is treated at water treatment facilities before it is distributed to the people who use it. This treatment method is referred to as treatment at the source because contaminants are removed in these facilities before water is distributed.\n" +
                "\n" +
                "If water is not treated before it is distributed, it must be treated at the point of use to ensure the quality of the water will not cause illness. One traditional method of treating water widely used worldwide is boiling water to remove contaminants. Water that is brought to a rolling boil for at least one to three minutes (slightly more in mountainous areas) kills most pathogens.\n" +
                "\n" +
                "A note of caution is due, however. Boiling water is generally not effective in removing chemical contaminants. In fact, it generally increases their concentration a bit. Boiled water also runs the risk of recontamination during the cooling process if not properly protected and stored. Additionally, boiling water requires a significant amount of fuel, which can exact a toll both financially and environmentally. Despite these limitations, boiling is still a standard treatment when any pathogen is at issue.\n" +
                "\n" +
                "Over the last several decades, new and innovative household water treatment systems have been developed by government agencies, NGOs, and the private sector to bring low-tech, low cost, and user-friendly solutions to people who must treat water in their homes.\n" +
                "\n" +
                "Some of the most common household treatment systems used in the developing world are chlorination, filtration, solar disinfection, combined filtration/chlorination, and combined flocculation/chlorination.");


        //in portrait mode
        if(findViewById(R.id.layout_portrait)!= null)
        {
            FragmentManager manager= this.getSupportFragmentManager();

            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.DetailFrag))
                    .show(manager.findFragmentById(R.id.ListFrag))
                    .commit();
        }

        //in land mode
        if(findViewById(R.id.layout_land)!= null)
        {
            FragmentManager manager= this.getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.DetailFrag))
                    .show(manager.findFragmentById(R.id.ListFrag))
                    .commit();
        }
    }

    @Override
    public void onItemSelected(int index) {

        tvDescription.setText(descriptions.get(index));

        if(findViewById(R.id.layout_portrait)!= null)
        {
            FragmentManager manager= this.getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.DetailFrag))
                    .hide(manager.findFragmentById(R.id.ListFrag))
                    .addToBackStack(null)
                    .commit();
        }

    }
}

