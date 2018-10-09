function stringManipulation(inputString){
    var count;
    //String to store new resulting String 
    var stringNew = "";
    var i=0;
    for(;i<inputString.length;i++){
        count = 0;
        if(inputString[i] === inputString[i+1]){
           for(var j=i+1;j<inputString.length;j++){            
                if(inputString[i] === inputString[j]){
                    count++;
                }else{
                    i=j-1;
                    break;
                }
            }
        }
        if(count === 0){ 
            stringNew += inputString[i];
        }
    }
        return stringNew;  
}

function isRepeatedExist(inputString){
    for(var index = 0; index < inputString.length; index++){
        if(inputString[index]===inputString[index+1]){
            return true;
        }
    }
    return false;
}

function getManipulatedString(inputString){
    while(true){
        if(!isRepeatedExist(inputString)){
            break;
        }
        inputString = stringManipulation(inputString);
    }
    return inputString;
}

/**
   stringManipulation("aaabbbcdeeffgh");
  getManipulatedString("eeabcddcbfgf");
  getManipulatedString("aaabbbcdeeffgh");
  getManipulatedString("aaabbbcdef");
 * 
 */