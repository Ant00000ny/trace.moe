package utilility

import com.fasterxml.jackson.module.kotlin.readValue

internal object Function {
    inline fun <reified T> String.convertTo(): T = Constant.objectMapper.readValue(this)
}
