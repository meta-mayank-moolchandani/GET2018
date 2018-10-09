String.prototype.repeatString = function(number) {
    var repeatedString = '';
   for (var i = 0; i < number; i++) {
       repeatedString += this.toString()+" ";
   }
   return repeatedString;
};

/**
  "hello".repeatString(5);
 */