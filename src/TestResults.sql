--table creation for test results

USE [MyDatabase]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[TestResults](
	[testname] [nvarchar](max) NOT NULL,
	[result] [bit] NOT NULL,
	[version_id] [bigint] NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO


