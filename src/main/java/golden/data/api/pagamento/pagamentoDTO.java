package golden.data.api.pagamento;

public record pagamentoDTO(Long id_pagamento, Float valor, String metodo_pagamento, String status_pagamento) {
}
