$(function() {

    // const jsonString = '[{"entrydateformatted":"March 2, 2024","entrydate":"March, 02 2024 00:00:00","meals":[{"entryid":17504,"othercomments":"","mealtime":"Breakfast","menudescription":["Closed for Spring Break"],"specials":""},{"entryid":17505,"othercomments":"","mealtime":"Lunch","menudescription":["Closed for Spring Break"],"specials":""},{"entryid":17506,"othercomments":"","mealtime":"Dinner","menudescription":["Closed for Spring Break"],"specials":""}],"entrydatedayofweek":"Saturday"}]'; // Your JSON string
    const jsonString = '[{"entrydateformatted":"March 13, 2024","entrydate":"March, 13 2024 00:00:00","meals":[{"entryid":17540,"othercomments":"","mealtime":"Breakfast","menudescription":["7:00 - 8:15 Hot Breakfast","Eggs","Breakfast Meat","Breakfast Potato","Biscuits & Gravy","Pancakes or Waffles","8:15 - 9:30 Continental Breakfast","MYO Belgian Waffle","Bagels/English Muffins","Hot & Cold Cereal","Assorted Pastries"],"specialslist":["Breakfast Anytime Bar"],"specials":"Breakfast Anytime Bar"},{"othercommentshtml":"Hot Soup","entryid":17541,"othercomments":"Hot Soup","mealtime":"Lunch","menudescription":["Smothered Pork Chops","Nashville Hot Chicken","Sweet Potato Casserole","Seasonal Vegetable"],"specialslist":["Breakfast Anytime Bar","Deluxe Salad Bar","Gluten-Free Bar","Grill Station","Habeneros","Pizza Bar","Pasta Bar","Sub Zone Bar"],"specials":"Breakfast Anytime Bar,Deluxe Salad Bar,Gluten-Free Bar,Grill Station,Habeneros,Pizza Bar,Pasta Bar,Sub Zone Bar"},{"entryid":17542,"othercomments":"","mealtime":"Dinner","menudescription":["BBQ Beef Sandwiches","Ranch Chicken","Vegetable Medley"],"specialslist":["Breakfast Anytime Bar","Deluxe Salad Bar","Gluten-Free Bar","Grill Station","Habeneros","Pizza Bar","Pasta Bar"],"specials":"Breakfast Anytime Bar,Deluxe Salad Bar,Gluten-Free Bar,Grill Station,Habeneros,Pizza Bar,Pasta Bar"}],"entrydatedayofweek":"Wednesday"}]';
    const menuJSString = JSON.parse(jsonString);
    let mealInfo = new Array();
    
    for(let i = 0; i < 3; i++) {
        let mealHTMLSection = "." + (menuJSString[0].meals[i].mealtime).toLowerCase() + "Menu";
        console.log(mealHTMLSection);
        // $(mealHTMLSection).empty();
        $(mealHTMLSection).children().append("<li></li>");
    }

    // mealInfo = Object.keys(menuJSString[0].meals.mealtime);

    // mealInfo.forEach(meal => {
    //     console.log(meal);
    // });

    // $.ajax({
	// 	url: "http://judah.cedarville.edu/~knoerr/cs3220/termProject/getCombined.php",
	// 	dataType: "json",
	// 	data: {}
	// }).done(function(menuJSON) {
        
    //     let menuJSString = JSON.parse(menuJSON);
    //     console.log(menuJSString);

    //     // let requirementCategories = new Array();
    //     // requirementCategories = Object.keys(requirementData.categories);
        
    //     // requirementCategories.forEach(category => {
    //     //     sectionID = "#" + category.toLowerCase() + "Requirements";
    //     //     populateRequirement(requirementData.categories[category].courses, sectionID);
    //     // });


    // }).fail(function() {
        
    // });
});