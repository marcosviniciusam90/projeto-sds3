import axios from "axios";
import Pagination from "components/Pagination";
import { useEffect, useState } from "react";
import { SalePage } from "types/sale";
import { formatLocalDate } from "utils/format";
import { BASE_URL } from "utils/requests";

const DataTable = () => {

  //Armazena estado do número da página atual - Valor inicial 0 - Não precisa parametrizar pois é tipo primitivo
  const [activePage, setActivePage] = useState(0);
  
  //Armazena estado da página em exibição - Foi necessário parametrizar e inicializar atributos do objeto SalePage
  const [page, setPage] = useState<SalePage>({
    first: true,
    last: true,
    number: 0,
    totalElements: 0,
    totalPages: 0
  });

  const changePage = (index: number) => {
    setActivePage(index);
  }

  //é executado quando a página (site) carregar ou houver alteração no estado do activePage (setActivePage) 
  useEffect(() => {
    axios.get(`${BASE_URL}/sales?page=${activePage}&size=20&sort=date,desc`)
      .then(response => {
        setPage(response.data);
      })
  }, [activePage]); 
      //o useEffect vai observar o estado do activePage, quando o estado mudar executa novamente o useEffect

  return (
    <>
      
      <Pagination page={page} onPageChange={changePage} />

      <div className="table-responsive">
        <table className="table table-striped table-sm">
          <thead>
            <tr>
              <th>Data</th>    { /* th: table head */}
              <th>Vendedor</th>
              <th>Clientes visitados</th>
              <th>Negócios fechados</th>
              <th>Valor</th>
            </tr>
          </thead>
          <tbody>
            {page.content?.map(item => ( /* Se 'content' for uma lista válida, pra cada item gera um registro/linha   */

              <tr key={item.id}>

                <td>{formatLocalDate(item.date, "dd/MM/yyyy")}</td>
                <td>{item.sellerName}</td>     { /* <td>{item.seller.name}</td> */}
                <td>{item.visited}</td>
                <td>{item.deals}</td>
                <td>{item.amount.toFixed(2)}</td>          { /* td: table data */}

              </tr>

            ))
            }
          </tbody>
        </table>
      </div >
    </>
  );
}

export default DataTable;
