//se existir a variável de ambiente definida usa o valor, caso contrário usa 'http://localhost:8080'
export const BASE_URL = process.env.REACT_APP_BACKEND_URL ?? 'http://localhost:8080';

/* 
Variáveis de ambiente com prefixo REACT_APP_ é padrão do Netlify, 
uma vez que tenha esse prefixo vai ser processada pelo browser e o
JavaScript terá acesso
*/