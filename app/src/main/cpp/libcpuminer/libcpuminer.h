#ifndef __LIB_CPU_MINER_H__
#define __LIB_CPU_MINER_H__
#ifdef __cplusplus
extern "C"{
#endif //__cplusplus

int init(void(*cb)(const char *format, va_list arg));
int start(const char* url, const char* user, const char* pass);
int stop();

#ifdef __cplusplus
}
#endif //__cplusplus
#endif //__LIB_CPU_MINER_H__
