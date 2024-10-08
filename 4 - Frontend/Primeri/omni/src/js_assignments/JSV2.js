/* 
    Zadatak 2
    Prošriti funkciju iz zadatka 1 tako da ne sortira samo brojeve u uzlaznom redosledu nego može da sortira bilo šta kroz komparatorsku funkciju koja vraća, za neko a i b, -1 kada a < b, 0 kada a == b, i 1 kada a > b. Takva funkcija za sortiranje dobija niz i funkciju. Testirati ovu funkciju tako što joj se da niz i funkcija koja sortira u silazećem redosledu. Inače, svaki niz ima funkciju .sort koja obavlja tačno ovaj posao koji ovde kodiramo, i prima kao parametar komparatorsku funkciju koja radi tačno kao ova koju opisujemo ovde. 
*/

const JSV2 = () => {

  //let array = [1, 2, 3 ,20, 4, 5, -8];
  let array = ['a', 'b', 'c', 'd'];

  function bubbleSort(arr, compare) {
    let n = arr.length;
    let swapped;
    do {
      swapped = false;
      for (let i = 1; i < n; i++) {
        if (compare(arr[i - 1], arr[i]) > 0) {
          let temp = arr[i - 1];
          arr[i - 1] = arr[i];
          arr[i] = temp;
          swapped = true;
        }
      }
      n--;
    } while (swapped);
    return arr;
  }

  function descendingComparator(a, b) {
    if (a < b) return 1;
    if (a > b) return -1;
    return 0;
  }

  return (
    <table border={1}>
      <tr>
        <th>Original array</th>
        <th>Sorted array</th>
      </tr>
      <tr>
        <td>
          <pre>{JSON.stringify(array)}</pre>
        </td>
        <td>{JSON.stringify(bubbleSort(array, descendingComparator))}</td>
      </tr>
    </table>
  );
};

export default JSV2;
