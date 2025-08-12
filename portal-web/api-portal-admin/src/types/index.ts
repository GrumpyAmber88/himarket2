// 导出所有类型定义
export * from './portal'
export * from './api-product'

// 通用API响应类型
export interface ApiResponse<T = any> {
  code: string;
  message: string;
  data: T;
} 