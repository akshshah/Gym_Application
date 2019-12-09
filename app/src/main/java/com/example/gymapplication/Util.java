package com.example.gymapplication;

import java.util.ArrayList;

public class Util {

    private static ArrayList<GymTraining> allTrainings;
    private static ArrayList<Plan> userPlans;
    public Util() {
    }

    public static void initializeAll()
    {
        if(null == allTrainings){
            allTrainings = new ArrayList<>();
        }
        if(null == userPlans)
        {
            userPlans = new ArrayList<>();
        }

        GymTraining squat = new GymTraining();
        squat.setName("Squat");
        squat.setShortDesc("The squat is a lower body exercise");
        squat.setLongDesc("The squat is performed by squatting down with a weight held across the upper back under neck and standing up straight again. This is a compound exercise that also involves the glutes (buttocks) and, to a lesser extent, the hamstrings, calves, and the lower back. Lifting belts are sometimes used to help support the lower back. The freeweight squat is one of 'The Big Three' powerlifting exercises, along with the deadlift and the bench press.");
        squat.setImageUrl("https://www.wikihow.com/images/thumb/6/60/Improve-a-Squat-Step-12-Version-3.jpg/aid4063769-v4-728px-Improve-a-Squat-Step-12-Version-3.jpg");
        allTrainings.add(squat);

        GymTraining pushup = new GymTraining();
        pushup.setName("Push Up");
        pushup.setShortDesc("Strengthens your arms and chest muscles");
        pushup.setLongDesc("A push-up (or press-up if the hands are wider than shoulders placing more emphasis on the pectoral muscles) is a common calisthenics exercise beginning from the prone position. By raising and lowering the body using the arms, push-ups exercise the pectoral muscles, triceps, and anterior deltoids, with ancillary benefits to the rest of the deltoids, serratus anterior, coracobrachialis and the midsection as a whole. ");
        pushup.setImageUrl("https://static.vecteezy.com/system/resources/previews/000/162/096/non_2x/man-doing-push-up-vector-illustration.jpg");
        allTrainings.add(pushup);

        GymTraining chestfly = new GymTraining();
        chestfly.setName("Chest Fly");
        chestfly.setShortDesc("Strengthens the chest and shoulders");
        chestfly.setLongDesc("The chest fly or pectoral fly (abbreviated to pec fly) primarily works the pectoralis major muscles to move the arms horizontally forward. If medially (internally) rotated, it is assisted in this by the anterior (front) head of the deltoideus in transverse flexion.The movement is performed lying on the back on a bench, starting weights extended above the chest, meeting at the midsagittal plane.This exercise can be done using other implements than dumbbells, such as kettlebells or weight plates.");
        chestfly.setImageUrl("https://api.kramesstaywell.com/Content/6066ca30-310a-4170-b001-a4ab013d61fd/ucr-images-v1/Images/woman-lying-on-back-with-knees-bent-doing-chest-fly-exercise-with-hand-weig");
        allTrainings.add(chestfly);

        GymTraining legpress = new GymTraining();
        legpress.setName("Leg Press");
        legpress.setShortDesc("Works the quads,hamstrings and glutes");
        legpress.setLongDesc("The leg press is a weight training exercise in which the individual pushes a weight or resistance away from them using their legs. The term leg press also refers to the apparatus used to perform this exercise. The leg press can be used to evaluate an athlete's overall lower body strength (from knee joint to hip). It has the potential to inflict grave injury: the knees could bend the wrong way if they are locked during a leg press.");
        legpress.setImageUrl("https://www.exercisegoals.com/images/legpress1.jpg");
        allTrainings.add(legpress);

        GymTraining deadlift = new GymTraining();
        deadlift.setName("Dead Lift");
        deadlift.setShortDesc("Strengthens the entire back and its surrounding muscles");
        deadlift.setLongDesc("Deadlift refers to the lifting of dead weight (weight without momentum), such as weights lying on the ground. It is one of the few standard weight training exercises in which all repetitions begin with dead weight. In most other lifts there is an eccentric (lowering of the weight) phase followed by the concentric (lifting of the weight) phase. During these exercises, a small amount of energy is stored in the stretched muscles and tendons in the eccentric phase if the lifter is not flexible beyond the range of motion. There are several positions one can approach when performing the deadlift, which include the conventional deadlift, squat, and sumo-deadlift.");
        deadlift.setImageUrl("https://thumbs.dreamstime.com/b/man-doing-deadlift-exercise-barbell-athletic-workout-man-doing-deadlift-exercise-barbell-athletic-workout-weight-152625603.jpg");
        allTrainings.add(deadlift);

        GymTraining pullup = new GymTraining();
        pullup.setName("Pull Up");
        pullup.setShortDesc("A pull-up is an upper-body strength exercise.");
        pullup.setLongDesc("The pull-up is a closed-chain movement where the body is suspended by the hands and pulls up. As this happens, the elbows flex and the shoulders adduct and extend to bring the elbows to the torso.The term chin-up, traditionally referring to a pull-up with the chin brought over the top of a bar, was used in the 1980s to refer to a pronated, or overhand, grip, with a supinated, or underhand, grip being called a chin-up. \"pull-up\" refers specifically to the exercise done with a pronated hand position. Pull-ups use many different muscles of the upper body, including the latissimus dorsi and the biceps brachii.");
        pullup.setImageUrl("https://media.istockphoto.com/vectors/pullup-on-the-crossbar-male-athlete-performs-the-exercise-sports-vector-id1059323414");
        allTrainings.add(pullup);
    }

    public static ArrayList<GymTraining> getAllTrainings() {
        return allTrainings;
    }

    public static void setAllTrainings(ArrayList<GymTraining> allTrainings) {
        Util.allTrainings = allTrainings;
    }

    public static ArrayList<Plan> getUserPlans() {
        return userPlans;
    }

    public static void setUserPlans(ArrayList<Plan> userPlans) {
        Util.userPlans = userPlans;
    }

    public static boolean addUserPlans(Plan plan)
    {
        return userPlans.add(plan);
    }
    public static boolean removePlan(Plan plan)
    {
        return userPlans.remove(plan);
    }

}
