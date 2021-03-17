const _ = {
    clamp (num, lowLim, highLim){
        const lowClampVal = Math.max(num, lowLim);
        const clampVal = Math.min(lowClampVal, highLim);
        return clampVal;
    },

    inRange(num, startVal, endVal){
      if (typeof endVal == 'undefined'){
            endVal=startVal;
            startVal = 0;
            }
      if (startVal > endVal){
            let swapVal = startVal;
            startVal=0;
            endVal = swapVal;
            }
      let isInRange = (startVal <= num && num < endVal);
        
        return isInRange;
    },

  words(string){
        const words = string.split(' ');
        return words;
    },

    pad(string, num){
        const stringLength = string.length;
        if(stringLength>=num){
            return string;
        }
        else{     
            const numSpacesToAdd = num - stringLength;
            const prefixLength = Math.floor(numSpacesToAdd/2);
            const sufixLength = numSpacesToAdd-prefixLength;
            const paddedString = ' '.repeat(prefixLength) + string + ' '.repeat(sufixLength);
            
            return paddedString;
        }
    },
    
    has(object, key){
        return object[key]? true : false;
    },

    invert(object){
        let newObject = {};
        for (key in object) {
            newObject[object[key]]=key;
        };
        return newObject;
    },

    findKey(object, func){
        for(key in object){
            let returned = func(object.key);
            if (returned === true){
                return key;
            }else return undefined;
        }
    },

    drop(arr, num){
        if(num === undefined){
            num = 1;
        }
        let newArr = arr.slice(num);
        return newArr;
    },

    dropWhile(arr, func){
        const cb = (element, index) =>{
            return !func(element, index, arr);
        }
        let dropNum = arr.findIndex(cb);
        let droppedArray = this.drop(arr, dropNum);
        return droppedArray;
    },

    chunk(array, size){
        if (size === undefined){
            size = 1;
        }
        const arrayChunks = [];
        for(let j = 0; j<array.length; j+=size){
            
/*          let arrayChunk=[]; 
            for(let i=j; i<j+size && i<array.length; i++){
                
                arrayChunk[i%size]=array[i];
            }
            arrayChunks[Math.floor(j/size)] = arrayChunk;
*/          
            let arrayChunk = array.slice(j, j+size);
            arrayChunks.push(arrayChunk);
        }
        return arrayChunks;
    }

}




// Do not write or modify code below this line.
module.exports = _;