import type { ReactNode } from "react";
import { Skeleton } from "antd";
import { Navigation } from "./Navigation";

interface LayoutProps {
  children: ReactNode;
  className?: string;
  loading?: boolean;
}

export function Layout({ children, className = "", loading = false }: LayoutProps) {
  return (
    <div className={`min-h-screen bg-[#f4f4f6] ${className}`}>
      <Navigation loading={loading} />
      <main className="pt-4">
        <div className="w-full mx-auto px-4 sm:px-6 lg:px-8 py-8">
          {loading ? (
            <div className="space-y-8">
              {/* 页面标题骨架屏 */}
              <div className="text-center mb-8">
                <Skeleton.Input active size="large" style={{ width: 300, height: 48, margin: '0 auto 16px' }} />
                <Skeleton.Input active size="small" style={{ width: '80%', height: 24, margin: '0 auto' }} />
              </div>
              
              {/* 搜索框骨架屏 */}
              <div className="flex justify-center mb-8">
                <div className="relative w-full max-w-2xl">
                  <Skeleton.Input active size="large" style={{ width: '100%', height: 40 }} />
                </div>
              </div>
              
              {/* 子标题骨架屏 */}
              <div className="mb-6">
                <Skeleton.Input active size="small" style={{ width: 200, height: 32 }} />
              </div>
              
              {/* 内容区域骨架屏 */}
              <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6 mb-8">
                {Array.from({ length: 6 }).map((_, index) => (
                  <div key={index} className="h-full rounded-lg shadow-lg bg-white p-4">
                    <div className="flex items-start space-x-4">
                      <Skeleton.Avatar size={48} active />
                      <div className="flex-1 min-w-0">
                        <div className="flex items-center justify-between mb-2">
                          <Skeleton.Input active size="small" style={{ width: 120 }} />
                          <Skeleton.Input active size="small" style={{ width: 60 }} />
                        </div>
                        <Skeleton.Input active size="small" style={{ width: 80, marginBottom: 8 }} />
                        <Skeleton.Input active size="small" style={{ width: '100%', marginBottom: 12 }} />
                        <Skeleton.Input active size="small" style={{ width: '100%', marginBottom: 12 }} />
                        <div className="flex items-center justify-between">
                          <Skeleton.Input active size="small" style={{ width: 60 }} />
                          <Skeleton.Input active size="small" style={{ width: 80 }} />
                        </div>
                      </div>
                    </div>
                  </div>
                ))}
              </div>
            </div>
          ) : (
            children
          )}
        </div>
      </main>
      {/* <Footer /> */}
    </div>
  );
} 