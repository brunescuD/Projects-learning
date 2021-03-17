// Returns a random DNA base
const returnRandBase = () => {
  const dnaBases = ['A', 'T', 'C', 'G'];
  return dnaBases[Math.floor(Math.random() * 4)];
};

// Returns a random single stand of DNA containing 15 bases
const mockUpStrand = () => {
  const newStrand = [];
  for (let i = 0; i < 15; i++) {
    newStrand.push(returnRandBase());
  }
  return newStrand;
};

/**factory function pAequorFactory() that has two parameters:
 * The first parameter is number (no two organisms should have the same number).
 * The second parameter is an array of 15 DNA bases.
 
 * pAequorFactory() should return an object that contains the properties specimenNum and dna that correspond to the parameters provided.
 */
const pAequorFactory = (number, dnaBasesArray) => {
  const newP = {
    specimenNum: number,
    dna: dnaBasesArray,

    mutate(){
      /**
       * .mutate() is responsible for:
       * randomly selecting a base in the object’s dna property 
       * and changing the current base to a different base. 
       * Then .mutate() will return the object’s dna.
       */
      const indexToMutt = Math.floor(Math.random()*this.dna.length);
      const sequenceToMutt = this.dna[indexToMutt];
      const availableMutationOptions = ['A', 'T', 'C', 'G'].filter(element => element!=sequenceToMutt);
      const mutatedSequenceVal = availableMutationOptions[Math.floor(Math.random()*availableMutationOptions.length)];
      this.dna[indexToMutt] = mutatedSequenceVal;
      return this.dna;
    },

    compareDNA(pAequorToCompare){
      /**The behavior of .compareDNA() is:
       *  to compare the current pAequor‘s .dna with the passed in pAequor‘s .dna 
       * and compute how many bases are identical and in the same locations. 
       * .compareDNA() does not return anything, but prints a message that states the percentage of DNA the two objects have in common 
       *    — use the .specimenNum to identify which pAequor objects are being compared.
       */
      const shortestSequence = Math.min(this.dna.length, pAequorToCompare.dna.length);
      let identicalValues = 0;
      for(let i=0; i<shortestSequence; i++){
        if(this.dna[i] === pAequorToCompare.dna[i]){
          identicalValues++;
        }
      }
      const commonPercentage = Math.round(100*identicalValues/shortestSequence);
      console.log(`specimen #${this.specimenNum} and specimen #${pAequorToCompare.specimenNum} have ${commonPercentage}% DNA in common`);
    },

    willLikelySurvive(){
      /**.willLikelySurvive() 
       * returns true if the object’s .dna array contains at least 60% 'C' or 'G' bases. 
       * Otherwise, .willLikelySurvive() returns false.
       */
      let numOfCorG = 0;
      for(let base of this.dna){
        if(base === 'C'||base === 'G'){
          numOfCorG++;
        }
      }
      console.log(numOfCorG);
      return numOfCorG >= 9;
    },

  }

  return newP;
}

let arrayOfpAequor= [];
for(let i=1; i<31; i++){
  let p = pAequorFactory(i, mockUpStrand());
  arrayOfpAequor.push(p);
}

console.log(arrayOfpAequor);






