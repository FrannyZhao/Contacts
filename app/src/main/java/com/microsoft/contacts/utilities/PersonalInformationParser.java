package com.microsoft.contacts.utilities;

import android.util.Log;

import com.microsoft.contacts.models.PersonalInformation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by zhaofengyi on 2018/12/8.
 */

public class PersonalInformationParser {
    private String jsonStr = "\n" +
            "[\n" +
            "  {\n" +
            "    \"first_name\": \"Allan\",\n" +
            "    \"last_name\": \"Munger\",\n" +
            "    \"avatar_filename\": \"Allan Munger.png\",\n" +
            "    \"title\": \"Writer\",\n" +
            "    \"introduction\": \"Ut malesuada sollicitudin tincidunt. Maecenas volutpat suscipit efficitur. Curabitur ut tortor sit amet lacus pellentesque convallis in laoreet lectus. Curabitur lorem velit, bibendum et vulputate vulputate, commodo in tortor. Curabitur a dapibus mauris. Vestibulum hendrerit euismod felis at hendrerit. Pellentesque imperdiet volutpat molestie. Nam vehicula dui eu consequat finibus. Phasellus sed placerat lorem. Nulla pretium a magna sit amet iaculis. Aenean eget eleifend elit. Ut eleifend aliquet interdum. Cras pulvinar elit a dapibus iaculis. Nullam fermentum porttitor ultrices.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Amanda\",\n" +
            "    \"last_name\": \"Brady\",\n" +
            "    \"avatar_filename\": \"Amanda Brady.png\",\n" +
            "    \"title\": \"Sales Representative\",\n" +
            "    \"introduction\": \"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam pulvinar neque in ullamcorper finibus. Aliquam ante orci, elementum non efficitur id, commodo ac velit. Proin non ornare neque, ac ornare odio. Nullam imperdiet tellus lacinia, semper justo vel, elementum metus. Aenean eget diam at quam dignissim varius. Nunc sed urna vehicula ipsum efficitur volutpat. Mauris vel augue ut magna tincidunt imperdiet. Integer sit amet vestibulum justo. Aenean placerat, nibh ac accumsan tincidunt, lorem arcu maximus justo, sed elementum tellus nisi id purus. Sed ac porttitor orci. Etiam et augue ullamcorper nibh mattis pharetra. Suspendisse ac mauris nec velit euismod rhoncus. Vestibulum tempor magna purus, id lacinia erat tempus eget.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Ashley\",\n" +
            "    \"last_name\": \"Mc Carthy\",\n" +
            "    \"avatar_filename\": \"Ashley Mc Carthy.png\",\n" +
            "    \"title\": \"Sales Representative\",\n" +
            "    \"introduction\": \"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam pulvinar neque in ullamcorper finibus. Aliquam ante orci, elementum non efficitur id, commodo ac velit. Proin non ornare neque, ac ornare odio. Nullam imperdiet tellus lacinia, semper justo vel, elementum metus. Aenean eget diam at quam dignissim varius. Nunc sed urna vehicula ipsum efficitur volutpat. Mauris vel augue ut magna tincidunt imperdiet. Integer sit amet vestibulum justo. Aenean placerat, nibh ac accumsan tincidunt, lorem arcu maximus justo, sed elementum tellus nisi id purus. Sed ac porttitor orci. Etiam et augue ullamcorper nibh mattis pharetra. Suspendisse ac mauris nec velit euismod rhoncus. Vestibulum tempor magna purus, id lacinia erat tempus eget.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Carlos\",\n" +
            "    \"last_name\": \"Slattery\",\n" +
            "    \"avatar_filename\": \"Carlos Slattery.png\",\n" +
            "    \"title\": \"Nurse\",\n" +
            "    \"introduction\": \"Phasellus eget pellentesque augue. Morbi quis est non urna posuere efficitur vitae ut erat. Nam aliquam ex a lacus fermentum mattis. Suspendisse a ligula rhoncus, pulvinar turpis a, sagittis elit. Morbi placerat urna accumsan, egestas turpis quis, commodo lorem. Nam convallis fermentum neque eu varius. Nullam sed gravida elit, at tincidunt est. Praesent arcu velit, vehicula rutrum leo ac, efficitur vestibulum lacus. Aliquam rutrum efficitur nulla, sed sollicitudin tellus suscipit ut. Vestibulum porta turpis vel purus vestibulum, ac euismod erat commodo. Nulla luctus ultricies blandit. Nunc faucibus, purus sit amet scelerisque tincidunt, augue elit posuere justo, id tristique sem elit nec nunc. Fusce congue dui vel sem aliquet volutpat. Nullam eget tincidunt nulla. Aenean interdum, turpis nec accumsan sollicitudin, risus mi pellentesque eros, nec iaculis lectus ligula ut tellus. Phasellus at aliquet nisl, at aliquam nulla.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Carole\",\n" +
            "    \"last_name\": \"Poland\",\n" +
            "    \"avatar_filename\": \"Carole Poland.png\",\n" +
            "    \"title\": \"Internet/Social Media Evaluator\",\n" +
            "    \"introduction\": \"Praesent pellentesque, sapien ut lobortis lacinia, erat magna venenatis turpis, eu maximus magna lectus a sapien. Aenean luctus tellus vel dui euismod bibendum. Aenean at elementum neque. Integer non aliquam risus. Ut porta, lectus et finibus sodales, mi nulla hendrerit dui, finibus consectetur arcu ligula ac velit. Suspendisse eu mollis diam. Vestibulum porta, elit a dignissim mollis, dolor risus sagittis sapien, quis tristique nunc massa interdum ligula. Duis a turpis nulla. Vivamus a consequat justo.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Cecil\",\n" +
            "    \"last_name\": \"Folk\",\n" +
            "    \"avatar_filename\": \"Cecil Folk.png\",\n" +
            "    \"title\": \"Territory Sales Manager\",\n" +
            "    \"introduction\": \"Praesent pellentesque, sapien ut lobortis lacinia, erat magna venenatis turpis, eu maximus magna lectus a sapien. Aenean luctus tellus vel dui euismod bibendum. Aenean at elementum neque. Integer non aliquam risus. Ut porta, lectus et finibus sodales, mi nulla hendrerit dui, finibus consectetur arcu ligula ac velit. Suspendisse eu mollis diam. Vestibulum porta, elit a dignissim mollis, dolor risus sagittis sapien, quis tristique nunc massa interdum ligula. Duis a turpis nulla. Vivamus a consequat justo.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Celeste\",\n" +
            "    \"last_name\": \"Burton\",\n" +
            "    \"avatar_filename\": \"Celeste Burton.png\",\n" +
            "    \"title\": \"Case Manager\",\n" +
            "    \"introduction\": \"Ut malesuada sollicitudin tincidunt. Maecenas volutpat suscipit efficitur. Curabitur ut tortor sit amet lacus pellentesque convallis in laoreet lectus. Curabitur lorem velit, bibendum et vulputate vulputate, commodo in tortor. Curabitur a dapibus mauris. Vestibulum hendrerit euismod felis at hendrerit. Pellentesque imperdiet volutpat molestie. Nam vehicula dui eu consequat finibus. Phasellus sed placerat lorem. Nulla pretium a magna sit amet iaculis. Aenean eget eleifend elit. Ut eleifend aliquet interdum. Cras pulvinar elit a dapibus iaculis. Nullam fermentum porttitor ultrices.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Charlotte\",\n" +
            "    \"last_name\": \"Waltson\",\n" +
            "    \"avatar_filename\": \"Charlotte Waltson.png\",\n" +
            "    \"title\": \"Editor\",\n" +
            "    \"introduction\": \"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam pulvinar neque in ullamcorper finibus. Aliquam ante orci, elementum non efficitur id, commodo ac velit. Proin non ornare neque, ac ornare odio. Nullam imperdiet tellus lacinia, semper justo vel, elementum metus. Aenean eget diam at quam dignissim varius. Nunc sed urna vehicula ipsum efficitur volutpat. Mauris vel augue ut magna tincidunt imperdiet. Integer sit amet vestibulum justo. Aenean placerat, nibh ac accumsan tincidunt, lorem arcu maximus justo, sed elementum tellus nisi id purus. Sed ac porttitor orci. Etiam et augue ullamcorper nibh mattis pharetra. Suspendisse ac mauris nec velit euismod rhoncus. Vestibulum tempor magna purus, id lacinia erat tempus eget.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Colin\",\n" +
            "    \"last_name\": \"Ballinger\",\n" +
            "    \"avatar_filename\": \"Colin Ballinger.png\",\n" +
            "    \"title\": \"Developer\",\n" +
            "    \"introduction\": \"Phasellus eget pellentesque augue. Morbi quis est non urna posuere efficitur vitae ut erat. Nam aliquam ex a lacus fermentum mattis. Suspendisse a ligula rhoncus, pulvinar turpis a, sagittis elit. Morbi placerat urna accumsan, egestas turpis quis, commodo lorem. Nam convallis fermentum neque eu varius. Nullam sed gravida elit, at tincidunt est. Praesent arcu velit, vehicula rutrum leo ac, efficitur vestibulum lacus. Aliquam rutrum efficitur nulla, sed sollicitudin tellus suscipit ut. Vestibulum porta turpis vel purus vestibulum, ac euismod erat commodo. Nulla luctus ultricies blandit. Nunc faucibus, purus sit amet scelerisque tincidunt, augue elit posuere justo, id tristique sem elit nec nunc. Fusce congue dui vel sem aliquet volutpat. Nullam eget tincidunt nulla. Aenean interdum, turpis nec accumsan sollicitudin, risus mi pellentesque eros, nec iaculis lectus ligula ut tellus. Phasellus at aliquet nisl, at aliquam nulla.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Daisy\",\n" +
            "    \"last_name\": \"Phillips\",\n" +
            "    \"avatar_filename\": \"Daisy Phillips.png\",\n" +
            "    \"title\": \"Tutor\",\n" +
            "    \"introduction\": \"Ut malesuada sollicitudin tincidunt. Maecenas volutpat suscipit efficitur. Curabitur ut tortor sit amet lacus pellentesque convallis in laoreet lectus. Curabitur lorem velit, bibendum et vulputate vulputate, commodo in tortor. Curabitur a dapibus mauris. Vestibulum hendrerit euismod felis at hendrerit. Pellentesque imperdiet volutpat molestie. Nam vehicula dui eu consequat finibus. Phasellus sed placerat lorem. Nulla pretium a magna sit amet iaculis. Aenean eget eleifend elit. Ut eleifend aliquet interdum. Cras pulvinar elit a dapibus iaculis. Nullam fermentum porttitor ultrices.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Elliot\",\n" +
            "    \"last_name\": \"Woodward\",\n" +
            "    \"avatar_filename\": \"Elliot Woodward.png\",\n" +
            "    \"title\": \"Project Manager\",\n" +
            "    \"introduction\": \"Ut malesuada sollicitudin tincidunt. Maecenas volutpat suscipit efficitur. Curabitur ut tortor sit amet lacus pellentesque convallis in laoreet lectus. Curabitur lorem velit, bibendum et vulputate vulputate, commodo in tortor. Curabitur a dapibus mauris. Vestibulum hendrerit euismod felis at hendrerit. Pellentesque imperdiet volutpat molestie. Nam vehicula dui eu consequat finibus. Phasellus sed placerat lorem. Nulla pretium a magna sit amet iaculis. Aenean eget eleifend elit. Ut eleifend aliquet interdum. Cras pulvinar elit a dapibus iaculis. Nullam fermentum porttitor ultrices.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Elvia\",\n" +
            "    \"last_name\": \"Atkins\",\n" +
            "    \"avatar_filename\": \"Elvia Atkins.png\",\n" +
            "    \"title\": \"Tutor\",\n" +
            "    \"introduction\": \"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam pulvinar neque in ullamcorper finibus. Aliquam ante orci, elementum non efficitur id, commodo ac velit. Proin non ornare neque, ac ornare odio. Nullam imperdiet tellus lacinia, semper justo vel, elementum metus. Aenean eget diam at quam dignissim varius. Nunc sed urna vehicula ipsum efficitur volutpat. Mauris vel augue ut magna tincidunt imperdiet. Integer sit amet vestibulum justo. Aenean placerat, nibh ac accumsan tincidunt, lorem arcu maximus justo, sed elementum tellus nisi id purus. Sed ac porttitor orci. Etiam et augue ullamcorper nibh mattis pharetra. Suspendisse ac mauris nec velit euismod rhoncus. Vestibulum tempor magna purus, id lacinia erat tempus eget.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Erik\",\n" +
            "    \"last_name\": \"Nason\",\n" +
            "    \"avatar_filename\": \"Erik Nason.png\",\n" +
            "    \"title\": \"Consultant\",\n" +
            "    \"introduction\": \"Phasellus eget pellentesque augue. Morbi quis est non urna posuere efficitur vitae ut erat. Nam aliquam ex a lacus fermentum mattis. Suspendisse a ligula rhoncus, pulvinar turpis a, sagittis elit. Morbi placerat urna accumsan, egestas turpis quis, commodo lorem. Nam convallis fermentum neque eu varius. Nullam sed gravida elit, at tincidunt est. Praesent arcu velit, vehicula rutrum leo ac, efficitur vestibulum lacus. Aliquam rutrum efficitur nulla, sed sollicitudin tellus suscipit ut. Vestibulum porta turpis vel purus vestibulum, ac euismod erat commodo. Nulla luctus ultricies blandit. Nunc faucibus, purus sit amet scelerisque tincidunt, augue elit posuere justo, id tristique sem elit nec nunc. Fusce congue dui vel sem aliquet volutpat. Nullam eget tincidunt nulla. Aenean interdum, turpis nec accumsan sollicitudin, risus mi pellentesque eros, nec iaculis lectus ligula ut tellus. Phasellus at aliquet nisl, at aliquam nulla.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Henry\",\n" +
            "    \"last_name\": \"Brill\",\n" +
            "    \"avatar_filename\": \"Henry Brill.png\",\n" +
            "    \"title\": \"Tutor\",\n" +
            "    \"introduction\": \"Praesent pellentesque, sapien ut lobortis lacinia, erat magna venenatis turpis, eu maximus magna lectus a sapien. Aenean luctus tellus vel dui euismod bibendum. Aenean at elementum neque. Integer non aliquam risus. Ut porta, lectus et finibus sodales, mi nulla hendrerit dui, finibus consectetur arcu ligula ac velit. Suspendisse eu mollis diam. Vestibulum porta, elit a dignissim mollis, dolor risus sagittis sapien, quis tristique nunc massa interdum ligula. Duis a turpis nulla. Vivamus a consequat justo.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Isaac\",\n" +
            "    \"last_name\": \"Fielder\",\n" +
            "    \"avatar_filename\": \"Isaac Fielder.png\",\n" +
            "    \"title\": \"Teacher\",\n" +
            "    \"introduction\": \"Suspendisse venenatis eros et leo dignissim faucibus. Nullam egestas purus non scelerisque gravida. Sed ultricies gravida metus, eu rhoncus neque. Donec varius sem et metus luctus, eget maximus felis imperdiet. Aliquam id eros ipsum. Sed magna ligula, faucibus tristique ornare a, sagittis non ex. Aenean facilisis, mi at interdum lobortis, lectus eros fermentum magna, finibus porta lacus ipsum ut ipsum. Sed placerat nisl vel arcu finibus elementum. Fusce porta fringilla velit, quis aliquam leo porta consequat. Cras lobortis sapien id lectus sollicitudin elementum. Sed arcu leo, euismod in nulla eu, eleifend fermentum sapien.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Johnie\",\n" +
            "    \"last_name\": \"McConnell\",\n" +
            "    \"avatar_filename\": \"Johnie McConnell.png\",\n" +
            "    \"title\": \"Tutor\",\n" +
            "    \"introduction\": \"Suspendisse venenatis eros et leo dignissim faucibus. Nullam egestas purus non scelerisque gravida. Sed ultricies gravida metus, eu rhoncus neque. Donec varius sem et metus luctus, eget maximus felis imperdiet. Aliquam id eros ipsum. Sed magna ligula, faucibus tristique ornare a, sagittis non ex. Aenean facilisis, mi at interdum lobortis, lectus eros fermentum magna, finibus porta lacus ipsum ut ipsum. Sed placerat nisl vel arcu finibus elementum. Fusce porta fringilla velit, quis aliquam leo porta consequat. Cras lobortis sapien id lectus sollicitudin elementum. Sed arcu leo, euismod in nulla eu, eleifend fermentum sapien.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Kat\",\n" +
            "    \"last_name\": \"larsson\",\n" +
            "    \"avatar_filename\": \"Kat larsson.png\",\n" +
            "    \"title\": \"Engineer\",\n" +
            "    \"introduction\": \"Ut malesuada sollicitudin tincidunt. Maecenas volutpat suscipit efficitur. Curabitur ut tortor sit amet lacus pellentesque convallis in laoreet lectus. Curabitur lorem velit, bibendum et vulputate vulputate, commodo in tortor. Curabitur a dapibus mauris. Vestibulum hendrerit euismod felis at hendrerit. Pellentesque imperdiet volutpat molestie. Nam vehicula dui eu consequat finibus. Phasellus sed placerat lorem. Nulla pretium a magna sit amet iaculis. Aenean eget eleifend elit. Ut eleifend aliquet interdum. Cras pulvinar elit a dapibus iaculis. Nullam fermentum porttitor ultrices.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Katri\",\n" +
            "    \"last_name\": \"Ahokas\",\n" +
            "    \"avatar_filename\": \"Katri Ahokas.png\",\n" +
            "    \"title\": \"Developer\",\n" +
            "    \"introduction\": \"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam pulvinar neque in ullamcorper finibus. Aliquam ante orci, elementum non efficitur id, commodo ac velit. Proin non ornare neque, ac ornare odio. Nullam imperdiet tellus lacinia, semper justo vel, elementum metus. Aenean eget diam at quam dignissim varius. Nunc sed urna vehicula ipsum efficitur volutpat. Mauris vel augue ut magna tincidunt imperdiet. Integer sit amet vestibulum justo. Aenean placerat, nibh ac accumsan tincidunt, lorem arcu maximus justo, sed elementum tellus nisi id purus. Sed ac porttitor orci. Etiam et augue ullamcorper nibh mattis pharetra. Suspendisse ac mauris nec velit euismod rhoncus. Vestibulum tempor magna purus, id lacinia erat tempus eget.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Kevin\",\n" +
            "    \"last_name\": \"Sturgis\",\n" +
            "    \"avatar_filename\": \"Kevin Sturgis.png\",\n" +
            "    \"title\": \"Territory Sales Manager\",\n" +
            "    \"introduction\": \"Suspendisse venenatis eros et leo dignissim faucibus. Nullam egestas purus non scelerisque gravida. Sed ultricies gravida metus, eu rhoncus neque. Donec varius sem et metus luctus, eget maximus felis imperdiet. Aliquam id eros ipsum. Sed magna ligula, faucibus tristique ornare a, sagittis non ex. Aenean facilisis, mi at interdum lobortis, lectus eros fermentum magna, finibus porta lacus ipsum ut ipsum. Sed placerat nisl vel arcu finibus elementum. Fusce porta fringilla velit, quis aliquam leo porta consequat. Cras lobortis sapien id lectus sollicitudin elementum. Sed arcu leo, euismod in nulla eu, eleifend fermentum sapien.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Kristin\",\n" +
            "    \"last_name\": \"Patterson\",\n" +
            "    \"avatar_filename\": \"Kristin Patterson.png\",\n" +
            "    \"title\": \"Writer\",\n" +
            "    \"introduction\": \"Phasellus eget pellentesque augue. Morbi quis est non urna posuere efficitur vitae ut erat. Nam aliquam ex a lacus fermentum mattis. Suspendisse a ligula rhoncus, pulvinar turpis a, sagittis elit. Morbi placerat urna accumsan, egestas turpis quis, commodo lorem. Nam convallis fermentum neque eu varius. Nullam sed gravida elit, at tincidunt est. Praesent arcu velit, vehicula rutrum leo ac, efficitur vestibulum lacus. Aliquam rutrum efficitur nulla, sed sollicitudin tellus suscipit ut. Vestibulum porta turpis vel purus vestibulum, ac euismod erat commodo. Nulla luctus ultricies blandit. Nunc faucibus, purus sit amet scelerisque tincidunt, augue elit posuere justo, id tristique sem elit nec nunc. Fusce congue dui vel sem aliquet volutpat. Nullam eget tincidunt nulla. Aenean interdum, turpis nec accumsan sollicitudin, risus mi pellentesque eros, nec iaculis lectus ligula ut tellus. Phasellus at aliquet nisl, at aliquam nulla.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Lydia\",\n" +
            "    \"last_name\": \"Bauer\",\n" +
            "    \"avatar_filename\": \"Lydia Bauer.png\",\n" +
            "    \"title\": \"Analyst\",\n" +
            "    \"introduction\": \"Phasellus eget pellentesque augue. Morbi quis est non urna posuere efficitur vitae ut erat. Nam aliquam ex a lacus fermentum mattis. Suspendisse a ligula rhoncus, pulvinar turpis a, sagittis elit. Morbi placerat urna accumsan, egestas turpis quis, commodo lorem. Nam convallis fermentum neque eu varius. Nullam sed gravida elit, at tincidunt est. Praesent arcu velit, vehicula rutrum leo ac, efficitur vestibulum lacus. Aliquam rutrum efficitur nulla, sed sollicitudin tellus suscipit ut. Vestibulum porta turpis vel purus vestibulum, ac euismod erat commodo. Nulla luctus ultricies blandit. Nunc faucibus, purus sit amet scelerisque tincidunt, augue elit posuere justo, id tristique sem elit nec nunc. Fusce congue dui vel sem aliquet volutpat. Nullam eget tincidunt nulla. Aenean interdum, turpis nec accumsan sollicitudin, risus mi pellentesque eros, nec iaculis lectus ligula ut tellus. Phasellus at aliquet nisl, at aliquam nulla.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Mauricio\",\n" +
            "    \"last_name\": \"August\",\n" +
            "    \"avatar_filename\": \"Mauricio August.png\",\n" +
            "    \"title\": \"Analyst\",\n" +
            "    \"introduction\": \"Suspendisse venenatis eros et leo dignissim faucibus. Nullam egestas purus non scelerisque gravida. Sed ultricies gravida metus, eu rhoncus neque. Donec varius sem et metus luctus, eget maximus felis imperdiet. Aliquam id eros ipsum. Sed magna ligula, faucibus tristique ornare a, sagittis non ex. Aenean facilisis, mi at interdum lobortis, lectus eros fermentum magna, finibus porta lacus ipsum ut ipsum. Sed placerat nisl vel arcu finibus elementum. Fusce porta fringilla velit, quis aliquam leo porta consequat. Cras lobortis sapien id lectus sollicitudin elementum. Sed arcu leo, euismod in nulla eu, eleifend fermentum sapien.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Miguel\",\n" +
            "    \"last_name\": \"Garcia\",\n" +
            "    \"avatar_filename\": \"Miguel Garcia.png\",\n" +
            "    \"title\": \"Account Manager\",\n" +
            "    \"introduction\": \"Phasellus eget pellentesque augue. Morbi quis est non urna posuere efficitur vitae ut erat. Nam aliquam ex a lacus fermentum mattis. Suspendisse a ligula rhoncus, pulvinar turpis a, sagittis elit. Morbi placerat urna accumsan, egestas turpis quis, commodo lorem. Nam convallis fermentum neque eu varius. Nullam sed gravida elit, at tincidunt est. Praesent arcu velit, vehicula rutrum leo ac, efficitur vestibulum lacus. Aliquam rutrum efficitur nulla, sed sollicitudin tellus suscipit ut. Vestibulum porta turpis vel purus vestibulum, ac euismod erat commodo. Nulla luctus ultricies blandit. Nunc faucibus, purus sit amet scelerisque tincidunt, augue elit posuere justo, id tristique sem elit nec nunc. Fusce congue dui vel sem aliquet volutpat. Nullam eget tincidunt nulla. Aenean interdum, turpis nec accumsan sollicitudin, risus mi pellentesque eros, nec iaculis lectus ligula ut tellus. Phasellus at aliquet nisl, at aliquam nulla.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Mona\",\n" +
            "    \"last_name\": \"Kane\",\n" +
            "    \"avatar_filename\": \"Mona Kane.png\",\n" +
            "    \"title\": \"Developer\",\n" +
            "    \"introduction\": \"Phasellus eget pellentesque augue. Morbi quis est non urna posuere efficitur vitae ut erat. Nam aliquam ex a lacus fermentum mattis. Suspendisse a ligula rhoncus, pulvinar turpis a, sagittis elit. Morbi placerat urna accumsan, egestas turpis quis, commodo lorem. Nam convallis fermentum neque eu varius. Nullam sed gravida elit, at tincidunt est. Praesent arcu velit, vehicula rutrum leo ac, efficitur vestibulum lacus. Aliquam rutrum efficitur nulla, sed sollicitudin tellus suscipit ut. Vestibulum porta turpis vel purus vestibulum, ac euismod erat commodo. Nulla luctus ultricies blandit. Nunc faucibus, purus sit amet scelerisque tincidunt, augue elit posuere justo, id tristique sem elit nec nunc. Fusce congue dui vel sem aliquet volutpat. Nullam eget tincidunt nulla. Aenean interdum, turpis nec accumsan sollicitudin, risus mi pellentesque eros, nec iaculis lectus ligula ut tellus. Phasellus at aliquet nisl, at aliquam nulla.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Robert\",\n" +
            "    \"last_name\": \"Tolbert\",\n" +
            "    \"avatar_filename\": \"Robert Tolbert.png\",\n" +
            "    \"title\": \"Territory Sales Manager\",\n" +
            "    \"introduction\": \"Phasellus eget pellentesque augue. Morbi quis est non urna posuere efficitur vitae ut erat. Nam aliquam ex a lacus fermentum mattis. Suspendisse a ligula rhoncus, pulvinar turpis a, sagittis elit. Morbi placerat urna accumsan, egestas turpis quis, commodo lorem. Nam convallis fermentum neque eu varius. Nullam sed gravida elit, at tincidunt est. Praesent arcu velit, vehicula rutrum leo ac, efficitur vestibulum lacus. Aliquam rutrum efficitur nulla, sed sollicitudin tellus suscipit ut. Vestibulum porta turpis vel purus vestibulum, ac euismod erat commodo. Nulla luctus ultricies blandit. Nunc faucibus, purus sit amet scelerisque tincidunt, augue elit posuere justo, id tristique sem elit nec nunc. Fusce congue dui vel sem aliquet volutpat. Nullam eget tincidunt nulla. Aenean interdum, turpis nec accumsan sollicitudin, risus mi pellentesque eros, nec iaculis lectus ligula ut tellus. Phasellus at aliquet nisl, at aliquam nulla.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Robin\",\n" +
            "    \"last_name\": \"Counts\",\n" +
            "    \"avatar_filename\": \"Robin Counts.png\",\n" +
            "    \"title\": \"Customer Service Representative\",\n" +
            "    \"introduction\": \"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam pulvinar neque in ullamcorper finibus. Aliquam ante orci, elementum non efficitur id, commodo ac velit. Proin non ornare neque, ac ornare odio. Nullam imperdiet tellus lacinia, semper justo vel, elementum metus. Aenean eget diam at quam dignissim varius. Nunc sed urna vehicula ipsum efficitur volutpat. Mauris vel augue ut magna tincidunt imperdiet. Integer sit amet vestibulum justo. Aenean placerat, nibh ac accumsan tincidunt, lorem arcu maximus justo, sed elementum tellus nisi id purus. Sed ac porttitor orci. Etiam et augue ullamcorper nibh mattis pharetra. Suspendisse ac mauris nec velit euismod rhoncus. Vestibulum tempor magna purus, id lacinia erat tempus eget.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Tim\",\n" +
            "    \"last_name\": \"Deboer\",\n" +
            "    \"avatar_filename\": \"Tim Deboer.png\",\n" +
            "    \"title\": \"Developer\",\n" +
            "    \"introduction\": \"Suspendisse venenatis eros et leo dignissim faucibus. Nullam egestas purus non scelerisque gravida. Sed ultricies gravida metus, eu rhoncus neque. Donec varius sem et metus luctus, eget maximus felis imperdiet. Aliquam id eros ipsum. Sed magna ligula, faucibus tristique ornare a, sagittis non ex. Aenean facilisis, mi at interdum lobortis, lectus eros fermentum magna, finibus porta lacus ipsum ut ipsum. Sed placerat nisl vel arcu finibus elementum. Fusce porta fringilla velit, quis aliquam leo porta consequat. Cras lobortis sapien id lectus sollicitudin elementum. Sed arcu leo, euismod in nulla eu, eleifend fermentum sapien.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Wanda\",\n" +
            "    \"last_name\": \"Howard\",\n" +
            "    \"avatar_filename\": \"Wanda Howard.png\",\n" +
            "    \"title\": \"Accountant\",\n" +
            "    \"introduction\": \"Suspendisse venenatis eros et leo dignissim faucibus. Nullam egestas purus non scelerisque gravida. Sed ultricies gravida metus, eu rhoncus neque. Donec varius sem et metus luctus, eget maximus felis imperdiet. Aliquam id eros ipsum. Sed magna ligula, faucibus tristique ornare a, sagittis non ex. Aenean facilisis, mi at interdum lobortis, lectus eros fermentum magna, finibus porta lacus ipsum ut ipsum. Sed placerat nisl vel arcu finibus elementum. Fusce porta fringilla velit, quis aliquam leo porta consequat. Cras lobortis sapien id lectus sollicitudin elementum. Sed arcu leo, euismod in nulla eu, eleifend fermentum sapien.\"\n" +
            "  }\n" +
            "]";

    public ArrayList<PersonalInformation> parse() {
        ArrayList<PersonalInformation> result = new ArrayList<>();
        try {
            JSONArray content = new JSONArray(jsonStr);
            for (int i = 0; i < content.length(); i++) {
                JSONObject jsonObject = content.optJSONObject(i);
                PersonalInformation personalInformation = new PersonalInformation();
                personalInformation.setFirstName(jsonObject.optString("first_name", ""));
                personalInformation.setLastName(jsonObject.optString("last_name", ""));
                personalInformation.setAvatarFileName(jsonObject.optString("avatar_filename", "").toLowerCase().replace(" ", "_").split("\\.")[0]);
                personalInformation.setTitle(jsonObject.optString("title", ""));
                personalInformation.setIntroduction(jsonObject.optString("introduction", ""));
                result.add(personalInformation);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return result;
    }
}
